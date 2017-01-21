package sample;

import java.net.URL;
import java.util.ResourceBundle;

import SimpleParser.ParserException;
import SimpleParser.ParserInfixToTree;
import SimpleParser.ParserTreeNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextArea txtAData;

    @FXML
    private TextField txtEx;

    @FXML
    void handlerEval(ActionEvent event) {

        String term=txtEx.getText().trim();

        ParserInfixToTree parserInfixToTree=new ParserInfixToTree();
        ParserTreeNode treeNode= null;
        try {
            treeNode = parserInfixToTree.toTreeParse(term);
        } catch (ParserException e) {
            e.printStackTrace();
        }
        treeNode.printNode(treeNode);
        System.out.println(treeNode.builder.toString());
        txtAData.clear();
        txtAData.setText(treeNode.builder.toString());
    }

    @FXML
    void initialize() {

    }
}
