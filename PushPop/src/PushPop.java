import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import java.util.ArrayList;


public class PushPop extends Application {	
	
	//Create text area and field
	TextArea stack = new TextArea();
	TextField txtPush = new TextField();	

	//Create BorderPane 
		 protected BorderPane getPane() {
			 
			//create all events for when buttons are pressed 
			  EventHandler<ActionEvent> pushEvent = event -> push();
		        txtPush.setOnAction(pushEvent);
		        
		        EventHandler<ActionEvent> queueEvent = event -> queue();
		        txtPush.setOnAction(queueEvent);
		        
		      EventHandler<ActionEvent> popEvent = event -> pop();
		      
		      EventHandler<ActionEvent> deQueueEvent = event -> deQueue();
		      
		      EventHandler<ActionEvent> clearEvent = event -> clear();
			 
		      //create pane for buttons and attach correct actions to buttons
			    HBox paneForButtons = new HBox(6);
			    
			    Button btPop = new Button("Pop");
			    Button btClear = new Button("Clear");
			    Button btToggle = new Button("Change to Queue");
			    Button btPush = new Button("Push");
			    
			    btPush.setOnAction(pushEvent);
			    			    
			    btPop.setOnAction(popEvent);
			    
			    btClear.setOnAction(clearEvent);
			    
			    btToggle.setOnAction(e -> {
			    		if (btToggle.getText().equals("Change to Queue")) {
			    			btToggle.setText("Change to Push");
			    			btPush.setText("Enter Queue");
			    			btPop.setText("DeQueue");
			    			btPush.setOnAction(queueEvent);
			    			btPop.setOnAction(deQueueEvent);
			    		} else {
			    			btToggle.setText("Change to Queue");
			    			btPush.setText("Push");
			    			btPop.setText("Pop");
			    			btPush.setOnAction(pushEvent);
			    			btPop.setOnAction(popEvent);
			    		}
			    	});
			    
/* Would cause extra click when pressing push button.	
 		    btPush.setOnAction(e -> {
			    	if (btPush.getText().equals("Push")) {
			    		btPush.setOnAction(pushEvent);
			    	}else{
			    		btPush.setOnAction(queueEvent);
			    	}
		 		});*/
			    
			      //put all buttons on pane
			    paneForButtons.getChildren().addAll(btPush, txtPush, btPop, btToggle, btClear);
			    paneForButtons.setAlignment(Pos.CENTER_LEFT );
			    
			    BorderPane pane = new BorderPane();
			    pane.setTop(paneForButtons);
			    
			    //create and add pane for text stack
			    Pane paneForText = new Pane();
			    paneForText.getChildren().add(stack);
			    pane.setCenter(paneForText);
			    			    
			 // Set the font in the label and the text field
			    stack.setFont(new Font("Serif", 14));
			    stack.setWrapText(true);
			    stack.setEditable(false);
			    
			    return pane;
		 }
			@Override // Override the start method in the Application class
			  public void start(Stage primaryStage) {
		 
			    // Create a scene and place it in the stage
			    Scene scene = new Scene(getPane(), 470, 200);
			    primaryStage.setTitle("PushPop"); // Set the stage title
			    primaryStage.setScene(scene); // Place the scene in the stage
			    primaryStage.show(); // Display the stage
			  }
			
//create array list and all various methods to add and subtract from list			
		private ArrayList<Double> list = new ArrayList<>();
			
			public void push(){
				double pushNum = Double.parseDouble(txtPush.getText());
				list.add(pushNum);
				String s = String.format(list.toString());
				stack.setText(s);
			}
			
			public void queue(){
				double pushNum = Double.parseDouble(txtPush.getText());
				list.add(0, pushNum);
				String s = String.format(list.toString());
				stack.setText(s);
			}
			
			
			public void pop(){	
			    list.remove(list.size() - 1);
			
				String s = String.format(list.toString());
				stack.setText(s);
			}
			
			public void deQueue(){	
			    list.remove(0);
				String s = String.format(list.toString());
				stack.setText(s);
			}
			
			public void clear(){
					list.clear();
					String s = String.format(list.toString());
					stack.setText(s);
			}

	
	 //  Main not needed
	  public static void main(String[] args) {
	    launch(args);
	  }
}
