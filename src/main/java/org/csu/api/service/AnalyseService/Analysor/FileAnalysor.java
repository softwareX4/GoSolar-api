package org.csu.api.service.AnalyseService.Analysor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.csu.api.dto.FeatureDTO;
import org.csu.api.dto.FileDTO;
import org.csu.api.dto.StructDTO;
import org.csu.api.service.AnalyseService.generate.GoLexer;
import org.csu.api.service.AnalyseService.generate.GoParser;
import org.csu.api.service.AnalyseService.generate.GoParserBaseListener;
import org.csu.api.service.StatisticService.CodeCounter;
import org.csu.api.util.AppConst;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAnalysor {


    public static class FunctionListener extends GoParserBaseListener {
        int attr = 0;
        int methods = 0;


        public List<StructDTO> structs = new ArrayList<StructDTO>();

        @Override
        public void enterTypeSpec(GoParser.TypeSpecContext ctx) {

            if(ctx.type_().typeLit() != null){
                if(ctx.type_().typeLit().structType() != null ){

                    StructDTO struct = new StructDTO();
                    struct.setName(ctx.IDENTIFIER().getText());

                    //System.out.println("结构名："+ctx.IDENTIFIER());

                    FeatureDTO feature = new FeatureDTO();
                    feature.setType(AppConst.Type.STRUCT);

                    int methods = 0;
                    int attr = 0;

                    GoParser.StructTypeContext structCtx = ctx.type_().typeLit().structType();
                    for (GoParser.FieldDeclContext fieldDeclContext : structCtx.fieldDecl()){

                        if(fieldDeclContext.type_() != null){
                            if(fieldDeclContext.type_().typeLit() != null) {

                                if(fieldDeclContext.type_().typeLit().functionType() != null){

                                    methods ++;
                                    //System.out.println("函数： "+fieldDeclContext.identifierList().IDENTIFIER());
                                }
                            }
                        }
                        if(fieldDeclContext.identifierList() != null){
                            attr += fieldDeclContext.identifierList().IDENTIFIER().size();
                            //System.out.println("变量："+fieldDeclContext.identifierList().IDENTIFIER());
                        }

                    }

                    feature.setAttr(attr-methods);
                    feature.setMethods(methods);
                    struct.setFeature(feature);
                    structs.add(struct);

                }
            }
        }



        public void enterFunctionDecl(GoParser.FunctionDeclContext ctx) {
            String currentFunctionName = ctx.IDENTIFIER().getText();

            //System.out.println(currentFunctionName);
            methods++;
        }


        public void enterMethodDecl(GoParser.MethodDeclContext ctx) {
           // System.out.println("Now I enter a method named " + ctx.IDENTIFIER().getText());
            methods++;
        }

        public void enterVarDecl(GoParser.VarDeclContext ctx) {
            for (GoParser.VarSpecContext vc : ctx.varSpec()) {
                //System.out.println(vc.identifierList().IDENTIFIER());
                attr += vc.identifierList().IDENTIFIER().size();
            }
        }

        @Override public void enterShortVarDecl(GoParser.ShortVarDeclContext ctx) {
            //System.out.println(ctx.identifierList().IDENTIFIER());
            attr += ctx.identifierList().IDENTIFIER().size();
        }


        public static FileDTO analyse(String path) throws IOException {

            CharStream input = CharStreams.fromFileName(path);
            // ANTLRInputStream input = new ANTLRInputStream(is);
            GoLexer lexer = new GoLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            GoParser parser = new GoParser(tokens);
            parser.setBuildParseTree(true);
            ParseTree tree = parser.sourceFile();

            ParseTreeWalker walker = new ParseTreeWalker();
            FileAnalysor.FunctionListener collector = new FileAnalysor.FunctionListener();
            walker.walk(collector, tree);

            FileDTO fileDTO = new FileDTO();


            File file = new File(path);
            for(StructDTO s  : collector.structs){
                s.getFeature().setLoc(CodeCounter.countStuct(file,s.getName()));
                s.getFeature().setSrc(path);

            }

            //List<StructDTO> structDTOS = new StructAnalysor().analyse(path);
            fileDTO.setStructs(collector.structs);

            String fileNameNow = path.substring(path.lastIndexOf("\\")+1);
            //System.out.println(fileNameNow);
            fileDTO.setName(fileNameNow);

            FeatureDTO feature = new FeatureDTO();
            feature.setType(AppConst.Type.FILE);
            feature.setAttr(collector.attr);
            feature.setMethods(collector.methods);
            feature.setLoc(CodeCounter.count(new File(path)));
            feature.setSrc(path);

            fileDTO.setFileFeature(feature);

            //System.out.println(fileDTO.toString());
            return  fileDTO;

        }
    }

/*
    public static void main(String[] args) throws Exception {
        String path = "G:\\AAApersonal\\毕设\\project\\go-parse-master\\example\\struct_promotion.go";
        new FileAnalysor().analyse(path);

    }*/
}
