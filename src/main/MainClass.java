package main;

//lab4 for menu items on side of screen
//Hw3 for clipboard example

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainClass extends Application{ // SERIALIZABLE!!
	
	public static void main(String[] args) {
		//new RunProgram();
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Budget Planner");
        //primaryStage.setResizable(false); // stops resizing
        
        HBox menuLayout = setMenuLayout();
        //TilePane btnsLayout = setBtnLayout();  
        HBox btnsLayout = setBtnLayout();
        HBox imageLayout = setImageLayout();
        
        //***********ROOT*************************
        VBox root = new VBox(50);
        root.getChildren().addAll(menuLayout, btnsLayout, imageLayout);
        //****************************************
        
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.show();
    }
    
    private HBox setMenuLayout() {
    	
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(setFileMenu(), setEditMenu(), setHelpMenu());
		
		HBox menuLayout = new HBox(menuBar);
		HBox.setHgrow(menuBar, Priority.ALWAYS);		

		return menuLayout;
	}
    
    private Menu setFileMenu() {
    	
    	MenuItem newItem = new MenuItem("New");
    	newItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.ALT_DOWN, KeyCombination.SHIFT_DOWN));
    	MenuItem save = new MenuItem("Save");
    	save.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
    	MenuItem saveAs = new MenuItem("Save As");
    	MenuItem load = new MenuItem("Load");
    	MenuItem quit = new MenuItem("Quit");
    	
    	SeparatorMenuItem sep1 = new SeparatorMenuItem();
    	SeparatorMenuItem sep2 = new SeparatorMenuItem();
    	SeparatorMenuItem sep3 = new SeparatorMenuItem();
    	
    	Menu file = new Menu("File");
    	file.getItems().addAll(newItem, sep1, save, saveAs, sep2, load, sep3, quit);
    	
    	return file;    			
    }
    
    private Menu setEditMenu() {
    	
    	MenuItem copyCategory = new MenuItem("Copy Category");
    	copyCategory.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
    	MenuItem pasteCategory = new MenuItem("Paste Category");
    	pasteCategory.setAccelerator(new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
    	MenuItem deleteCategory = new MenuItem("Delete Category");
    	
    	SeparatorMenuItem sep = new SeparatorMenuItem();
    	
    	Menu edit = new Menu("Edit");
    	edit.getItems().addAll(copyCategory, pasteCategory, sep, deleteCategory);
    	
    	return edit;
    }
    
    private Menu setHelpMenu() {
    	
    	MenuItem about = new MenuItem("About");
    	about.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    public void handle(ActionEvent event) {
    	    	Hyperlink linkedInLink = new Hyperlink("www.linkedin.com/in/steven-mcconnell-8a2506195");
    	    	linkedInLink.setOnAction(new EventHandler<ActionEvent>() { // make a working link*************
    	            
    	            @Override
    	            public void handle(ActionEvent event) {
    	                System.out.println("New Clicked");
    	            }
    	            
    	        });
    	    	
    	    	Alert aboutAlert = new Alert(AlertType.INFORMATION);
    	    	aboutAlert.getDialogPane().setMinWidth(500);
    	    	aboutAlert.setTitle("About Budget Planner");
    	    	aboutAlert.setHeaderText(null);
    	    	aboutAlert.setContentText("Author: Steven McConnell\nLinkedIn Account: " + linkedInLink.getText()
    	    			+ "\nTitle: Software Engineer\nPublished: 2020");
    	    	aboutAlert.showAndWait();
    	    }
    	});
    	
    	Menu help = new Menu("Help"); 	
    	help.getItems().add(about);
    	
    	return help;
    }

	private HBox setImageLayout() {
        ImageView imageView = new ImageView(getImage());
        
        HBox imageLayout = new HBox(imageView);
        imageLayout.setAlignment(Pos.CENTER);
        
        return imageLayout;
    }
    
    private HBox setBtnLayout() {
        Button newBtn = newButtonSetup();
        Button loadBtn = loadButtonSetup();

        HBox btnLayout = new HBox();
        btnLayout.getChildren().addAll(newBtn, loadBtn);
        HBox.setMargin(newBtn, new Insets(10));
        HBox.setMargin(loadBtn, new Insets(10));
        btnLayout.setAlignment(Pos.BASELINE_CENTER);
        
        return btnLayout;
    }
    
    private Image getImage() { // push this responsibility to an image util
    	
    	Image image = null;
    	
    	try {
    		image = new Image("resources/titleImage.png", 300, 150, false, false);
    	}
    	catch(NullPointerException e) {
    		System.out.println("Image couldn't be loaded."); // add appropraite ERROR handling
    	}
    	
    	return image;
    }
    
    
    private Button newButtonSetup() {
    	Tooltip newTip = new Tooltip("Creates a new yearly budget");
    	Button newBtn = new Button();
        
        newBtn.setText("New Budget");
        newBtn.setTooltip(newTip);
        newBtn.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent event) {
                System.out.println("New Clicked");
            }
        });
        
        return newBtn;
    }
    
    private Button loadButtonSetup() {
    	Tooltip loadTip = new Tooltip("Loads a previously saved yearly budget");
		Button loadBtn = new Button();
		  	  
		loadBtn.setText("Load Budget");
		loadBtn.setTooltip(loadTip);
		loadBtn.setOnAction(new EventHandler<ActionEvent>() {
		  	
		@Override
			public void handle(ActionEvent event) {
				System.out.println("Load Clicked");
			}
		});
		  
		return loadBtn;
    }
}
	