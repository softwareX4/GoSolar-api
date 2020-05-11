package org.csu.api.service.AnalyseService.Analysor;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.csu.api.dto.FeatureDTO;
import org.csu.api.dto.StructDTO;
import org.csu.api.service.AnalyseService.generate.GoLexer;
import org.csu.api.service.AnalyseService.generate.GoParser;
import org.csu.api.service.AnalyseService.generate.GoParserBaseListener;
import org.csu.api.service.StatisticService.CodeCounter;
import org.csu.api.util.AppConst;
;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StructAnalysor {

    static class FunctionListener extends GoParserBaseListener {

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

    }


    public List<StructDTO> analyse(String path) throws IOException {

        CharStream input = CharStreams.fromFileName(path);
        // ANTLRInputStream input = new ANTLRInputStream(is);
        GoLexer lexer = new GoLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GoParser parser = new GoParser(tokens);
        parser.setBuildParseTree(true);
        ParseTree tree = parser.sourceFile();

        ParseTreeWalker walker = new ParseTreeWalker();
        FunctionListener collector = new FunctionListener();
        walker.walk(collector, tree);

        File file = new File(path);
        for(StructDTO s  : collector.structs){
            s.getFeature().setLoc(CodeCounter.countStuct(file,s.getName()));
            s.getFeature().setSrc(path);

        }

/*
        for(StructDTO s  : collector.structs){
            System.out.println(s.toString());
        }*/
        return  collector.structs;

    }/*
    public static void main(String[] args) throws Exception {
        String path = "G:\\AAApersonal\\毕设\\project\\go-parse-master\\example\\structs.go";
        new StructAnalysor().analyse(path);

    }*/
}
