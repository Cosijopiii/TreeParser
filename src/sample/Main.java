package sample;

import SimpleParser.ParserInfixToTree;
import SimpleParser.ParserException;
import SimpleParser.ParserTreeNode;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws ParserException {
//        ParserInfixToTree parserInfixToTree=new ParserInfixToTree();
//        ParserTreeNode treeNode= parserInfixToTree.toTreeParse("(1+2+3*3)*(3+(5/(3*3)))");
//        ParserTreeNode.printNode(treeNode);
//        System.out.println(treeNode.builder.toString());
        launch(args);
    }
}
