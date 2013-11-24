package pipe.gui.widgets;

import net.sourceforge.jeval.EvaluationException;
import parser.ExprEvaluator;
import parser.MarkingDividedByNumberException;
import pipe.controllers.PetriNetController;
import pipe.controllers.PipeApplicationController;
import pipe.gui.ApplicationSettings;
import pipe.gui.PetriNetTab;
import pipe.models.PetriNet;
import pipe.utilities.Copier;
import pipe.views.*;

import javax.swing.*;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Alex Charalambous
 * @author yufeiwang (minor changes)
 */
public class ArcWeightEditorPanel extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ArcView _arcView;
	boolean attributesVisible;

    private final PetriNetTab _view;
	private JRootPane _rootPane;
	
	private PetriNetView _pnmlData;

	/**
	 * Creates new form Arc Weight Editor
     * @param rootPane
     * @param arcView
     * @param _pnmlData
     * @param view
     */
	public ArcWeightEditorPanel(JRootPane rootPane, ArcView arcView,
			PetriNetView _pnmlData, PetriNetTab view) {
		_arcView = arcView;
		_view = view;
		_rootPane = rootPane;
		this._pnmlData=_pnmlData;

		initComponents();

		this._rootPane.setDefaultButton(okButton);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		inputtedWeights = new LinkedList<JTextField>();
		inputtedTokenClassNames = new LinkedList<String>();
        LinkedList<TokenView> tokenViews = ApplicationSettings.getApplicationView().getCurrentPetriNetView().getTokenViews();
		java.awt.GridBagConstraints gridBagConstraints;

        JPanel arcEditorPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton cancelButton = new JButton();
		okButton = new javax.swing.JButton();

		setLayout(new java.awt.GridBagLayout());

		arcEditorPanel.setBorder(javax.swing.BorderFactory
                                         .createTitledBorder("Arc Weight Editor"));
		arcEditorPanel.setLayout(new java.awt.GridBagLayout());
		Dimension d = new Dimension();
		d.setSize(300, 340);
		arcEditorPanel.setPreferredSize(d);
		// Now set new dimension used in for loop below
		d = new Dimension();
		d.setSize(50, 19);
		int x = 0;
		int y = 0;
		//LinkedList<MarkingView> weights = _arcView.getWeight();
		for (final TokenView tc : tokenViews) {
			if (tc.isEnabled()) {
				gridBagConstraints = new java.awt.GridBagConstraints();
				
				JLabel tokenClassName = new JLabel();
				final JTextField tokenClassWeight = new JTextField();
				tokenClassWeight.setEditable(true);
				tokenClassWeight.setName(tc.getID());
				

				tempExpr.add(new MarkingView(tc,_arcView.getWeightFunctionOfTokenClass(tc.getID()) ));
				tokenClassWeight.setText(_arcView.getWeightFunctionOfTokenClass(tc.getID()));
				inputtedWeights.add(tokenClassWeight);

				tokenClassName.setText(tc.getID() + ": ");
				inputtedTokenClassNames.add(tc.getID());
				
				gridBagConstraints.gridx = x;
				gridBagConstraints.gridy = y;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
				gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
				arcEditorPanel.add(tokenClassName, gridBagConstraints);
				
				JLabel con = new JLabel("Constant");
				gridBagConstraints.gridx = x+1;
				gridBagConstraints.gridy = y;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
				gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
				//arcEditorPanel.add(con, gridBagConstraints);
				

				
				//final JCheckBox constant = new JCheckBox();
//				if(_arcView.getWeightType(tc.getID()).equals("-1")){
//					_arcView.setWeightType(tc.getID(), "C");
//				}
//				constant.setSelected(!_arcView.getWeightType(tc.getID()).equals("F"));
//				gridBagConstraints.gridx = x+2;
//				gridBagConstraints.gridy = y;
//				gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
//				gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
//				arcEditorPanel.add(constant, gridBagConstraints);
				
				
				tokenClassWeight.setPreferredSize(d);
				//tokenClassWeight.setValue(0);
//				for (MarkingView currentWeight : weights) {
//					if (tc.hasSameId(currentWeight.getToken())) {
//						tokenClassWeight.setValue(currentWeight
//								.getCurrentMarking());
//					}
//				}

				tokenClassWeight
						.addFocusListener(new java.awt.event.FocusAdapter() {
							public void focusGained(
									java.awt.event.FocusEvent evt) {
								nameTextFieldFocusGained(evt);
							}

							public void focusLost(java.awt.event.FocusEvent evt) {
								nameTextFieldFocusLost(evt);
							}
						});
				tokenClassWeight.setEnabled(true);//constant.isSelected());
				
				gridBagConstraints = new java.awt.GridBagConstraints();
				gridBagConstraints.gridx = x + 3;
				gridBagConstraints.gridy = y;
				gridBagConstraints.gridwidth = 3;
				gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
				gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
				arcEditorPanel.add(tokenClassWeight, gridBagConstraints);
				
				
				JLabel fun = new JLabel("Functional");
				gridBagConstraints.gridx = x+1;
				gridBagConstraints.gridy = y+1;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
				gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
			//	arcEditorPanel.add(fun, gridBagConstraints);

				
				//final JCheckBox functional = new JCheckBox();
//				functional.setSelected(_arcView.getWeightType(tc.getID()).equals("F"));
//				gridBagConstraints.gridx = x+2;
//				gridBagConstraints.gridy = y+1;
//				gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
//				gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
//				arcEditorPanel.add(functional, gridBagConstraints);
				
				final JButton fweditor = new JButton("Weight expression editor");
				fweditor.setEnabled(true);
				gridBagConstraints.gridx = x+3;
				gridBagConstraints.gridy = y+1;
				gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
				gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
				arcEditorPanel.add(fweditor, gridBagConstraints);
				
//				constant.addActionListener(new java.awt.event.ActionListener() {
//
//			   	     @Override
//			   	     public void actionPerformed(java.awt.event.ActionEvent evt) {
//			   	    	//_arcView.setWeightType(tc.getID(),"C");
//			   	    	tokenClassWeight.setEnabled(true);
//			   	    	//functional.setSelected(false);
//			   	    	fweditor.setEnabled(false);
//			   	     }
//
//			   	     });
//				
//				functional.addActionListener(new java.awt.event.ActionListener() {
//
//			   	     @Override
//			   	     public void actionPerformed(java.awt.event.ActionEvent evt) {
//			   	    //	_arcView.setWeightType(tc.getID(),"F");
//			   	    	tokenClassWeight.setEnabled(false);
//			   	    	constant.setSelected(false);
//			   	    //functional.setSelected(true);
//			   	    	fweditor.setEnabled(true);
//			   	     }
//
//			   	     });
				
				fweditor.addActionListener(new java.awt.event.ActionListener() {

			   	     @Override
			   	     public void actionPerformed(java.awt.event.ActionEvent evt) {
			   	    	createEditorWindow(tc);
			   	     }
			   	     });
				
				y+=2;
			}
		}
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		add(arcEditorPanel, gridBagConstraints);
		buttonPanel.setLayout(new java.awt.GridBagLayout());

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonHandler(evt);
            }
        });
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		buttonPanel.add(cancelButton, gridBagConstraints);

		okButton.setText("OK");
		okButton.setMaximumSize(new java.awt.Dimension(75, 25));
		okButton.setMinimumSize(new java.awt.Dimension(75, 25));
		okButton.setPreferredSize(new java.awt.Dimension(75, 25));
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonHandler(evt);
			}
		});
		okButton.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				okButtonKeyPressed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
		buttonPanel.add(okButton, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		gridBagConstraints.insets = new java.awt.Insets(5, 0, 8, 3);
		add(buttonPanel, gridBagConstraints);
	}// </editor-fold>//GEN-END:initComponents
	
	public void createEditorWindow(TokenView tc){
		EscapableDialog guiDialog = new EscapableDialog(ApplicationSettings.getApplicationView(), "PIPE2", true);
	    	ArcFunctionEditor feditor = new ArcFunctionEditor(tc.getID(), this, guiDialog,_pnmlData,_arcView,tc);
	    	 guiDialog.add(feditor);
	    	 guiDialog.setSize(270, 230);
	    	 guiDialog.setLocationRelativeTo(ApplicationSettings.getApplicationView());
	         guiDialog.setVisible(true);
	         guiDialog.dispose();
	}

	
	private void nameTextFieldFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_nameTextFieldFocusLost
		// focusLost(nameTextField);
	}// GEN-LAST:event_nameTextFieldFocusLost

	private void nameTextFieldFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_nameTextFieldFocusGained
		// focusGained(nameTextField);
	}// GEN-LAST:event_nameTextFieldFocusGained

	private void okButtonKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_okButtonKeyPressed
		if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
			okButtonHandler(new java.awt.event.ActionEvent(this, 0, ""));
		}
	}// GEN-LAST:event_okButtonKeyPressed

	CaretListener caretListener = new javax.swing.event.CaretListener() {
		public void caretUpdate(javax.swing.event.CaretEvent evt) {
			JTextField textField = (JTextField) evt.getSource();
			textField.setBackground(new Color(255, 255, 255));
			// textField.removeChangeListener(this);
		}
	};

	private void okButtonHandler(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonHandler
        List<MarkingView> newWeight = Copier.mediumCopy(_arcView.getWeightSimple());

        //TODO: PASS THIS IN
        PetriNet net = ApplicationSettings.getApplicationController().getActivePetriNetController().getPetriNet();
		ExprEvaluator parser = new ExprEvaluator(net);
		for (int i = 0; i < inputtedWeights.size(); i++) {
			String expr = inputtedWeights.get(i).getText();
			try {
				
				if(expr==null || expr.equals("")){
					System.err.println("Error in functional rates expression.");
					String message = " Expression is invalid. Please check your function.";
		            String title = "Error";
		            JOptionPane.showMessageDialog(null, message, title, JOptionPane.YES_NO_OPTION);
		            return;
				}
				
				
				String tokenClassName = inputtedTokenClassNames.get(i);
				if(parser.parseAndEvalExpr(expr,tokenClassName)!=-1){// && !parser.parseAndEvalExpr(func).){
					for(MarkingView marking :newWeight){
						if(marking.getToken().getID().equals(tokenClassName)){
							marking.setCurrentMarking(expr);
							break;
						}
					}
					//_arcView.setWeightFunctionByID(tokenClassName, expr);
				//	awep.setWeight(func, token.getID());
					//awep.updateWeight();
					//_arcView.setfunctionalWeightExpr(tokenClassName, expr);
					//_arcView.setWeightType(token.getID(), "F");
				}else if (parser.parseAndEvalExpr(expr,tokenClassName) == -2){
					JOptionPane.showMessageDialog(null,
							"Please make sure division and floating numbers are "+
					"surrounded by ceil() or floor()");
					return;
				}else{
					System.err.println("Error in functional rates expression.");
					String message = " Expression is invalid. Please check your function.";
	                String title = "Error";
	                JOptionPane.showMessageDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	                return;
				}
				//exit();
			}  catch (MarkingDividedByNumberException e) {
				JOptionPane.showMessageDialog(null,
						"Marking-dependent arc weight divided by number not supported.\r\n"
						+"Since this may cause non-integer arc weight.");
				return;
			}catch (Exception e) {
				System.err.println("Error in functional rates expression.");
				String message = " Expression is invalid. Please check your function.";
	            String title = "Error";
	            JOptionPane.showMessageDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	            return;
			}
		}
		
		
		
		_arcView.checkIfFunctionalWeightExists();
		if(_arcView.isWeightFunctional()){
			Object target =_arcView.getTarget();
			if(target instanceof TransitionView){
				if(((TransitionView) target).isInfiniteServer()){
					String message = "This arc points to an infinite server transition. \r\n"+
					    	  "Thus this arc could not have functional weights at the moment";
					   		   String title = "Error";
					   		   JOptionPane.showMessageDialog(null, message, title, JOptionPane.YES_NO_OPTION);
					   		   return;
				}
			}
		}



        PipeApplicationController controller = ApplicationSettings.getApplicationController();
        PetriNetController petriNetController = controller.getActivePetriNetController();
	    petriNetController.getHistoryManager().newEdit(); // new "transaction""
	    int totalMarking = 0;
		for (int i = 0; i < inputtedWeights.size(); i++) {
			String tokenClassName = inputtedTokenClassNames.get(i);
			
			String id = ApplicationSettings.getApplicationView().getCurrentPetriNetView().getTokenClassFromID(
                    tokenClassName).getID();
//			if(_arcView.getWeightType(id).equals("F")){// functional weight is selected
//				int pos = ApplicationSettings.getApplicationView()
//						.getCurrentPetriNetView()
//						.positionInTheList(tokenClassName, newWeight);
//				MarkingView m;
//				
//				if (pos >= 0) {
//					m = newWeight.get(pos);
//				} else {
//					m = new MarkingView(ApplicationSettings.getApplicationView()
//							.getCurrentPetriNetView()
//							.getTokenClassFromID(tokenClassName), 0 + "");
//					newWeight.add(m);
//				}
//				int currentMarking = m.getCurrentMarking();
//
//				MyParser parser = new MyParser();
//				int newMarking = parser.parseAndEvalExpr(_arcView.getWeightExpr(id), id).intValue();
//				if (newMarking < 0) {
//					JOptionPane.showMessageDialog(null,
//							"Weighting cannot be less than 0. Please re-enter");
//					return;
//				} else if (newMarking != currentMarking) {
//					m.setCurrentMarking(_arcView.getWeightExpr(id));
//				}
//				totalMarking += newMarking;
//			}else if (_arcView.getWeightType(id).equals("C")){// constant weight is selected
				int pos = ApplicationSettings.getApplicationView()
						.getCurrentPetriNetView()
						.positionInTheList(tokenClassName, newWeight);
				MarkingView m;
				if (pos >= 0) {
					m = newWeight.get(pos);
				} else {
					m = new MarkingView(ApplicationSettings.getApplicationView()
							.getCurrentPetriNetView()
							.getTokenClassFromID(tokenClassName), 0 + "");
					newWeight.add(m);
				}
				int currentMarking = m.getCurrentMarking();

				int newMarking = 0;
				try {
					newMarking = parser.parseAndEvalExpr(inputtedWeights.get(i)
							.getText(),inputtedTokenClassNames.get(i));
				} catch (EvaluationException e) {
					JOptionPane.showMessageDialog(null,
							"Error in Arc weight expression");
					return;
				} catch (MarkingDividedByNumberException eee) {
					JOptionPane.showMessageDialog(null,
							"Marking-dependent arc weight divided by number not supported.\r\n"
							+"Since this may cause non-integer arc weight.");
					return;
				} catch(Exception ee){
					JOptionPane.showMessageDialog(null,
							"Error in Arc weight expression");
					return;
				}
//				int newMarking = Integer.parseInt(inputtedWeights.get(i)
//						.getText());
				if(newMarking == -1){
					JOptionPane.showMessageDialog(null,
							"Error in weight expression. Please make sure\r\n it is an integer");
					return;
				}
				if(newMarking == -2){
					JOptionPane.showMessageDialog(null,
							"Please make sure division and floating numbers are "+
					"surrounded by ceil() or floor()");
					return;
				}
				if (newMarking < 0) {
					JOptionPane.showMessageDialog(null,
							"Weighting cannot be less than 0. Please re-enter");
					return;
				} 
				else if (newMarking != currentMarking) {
					m.setCurrentMarking(newMarking);
				}
				
				
				totalMarking += newMarking;
//			}else{ //the weight type is "-1", then we do nothing
//				
//			}

			
/*			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,
						"Please enter a positive integer greater than 0.",
						"Invalid entry", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (Exception exc) {
				exc.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"Please enter a positive integer greater than 0.",
						"Invalid entry", JOptionPane.ERROR_MESSAGE);
				return;
			}
*/		
				}
		if(totalMarking <= 0){
			JOptionPane.showMessageDialog(null,
					"Total weight of arc must be greater than 0. Please re-enter");
			return;
		}
        petriNetController.getHistoryManager().addEdit(
				_arcView.setWeight(newWeight));
		_arcView.addThisAsObserverToWeight(newWeight); // Steve Doubleday
		_arcView.repaint();
		exit();
	}

	/*
	 * 
	 * _view.getHistoryManager().newEdit(); // new "transaction"" String newName =
	 * "";//nameTextField.getText(); if (!newName.equals(name)) { if
	 * (_pnmlData.checkTransitionIDAvailability(newName)) {
	 * _view.getHistoryManager().addEdit(arc.setPNObjectName(newName)); } else { //
	 * aquest nom no est disponible... JOptionPane.showMessageDialog(null,
	 * "There is already a transition named " + newName, "Error",
	 * JOptionPane.WARNING_MESSAGE); return; } }
	 */

	// GEN-LAST:event_okButtonHandler

	private void exit() {
		_rootPane.getParent().setVisible(false);
	}

	private void cancelButtonHandler(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonHandler
		// Provisional!
		exit();
	}// GEN-LAST:event_cancelButtonHandler

    private javax.swing.JButton okButton;
    private LinkedList<JTextField> inputtedWeights;
	private LinkedList<String> inputtedTokenClassNames;
	// End of variables declaration//GEN-END:variables
	private	LinkedList<MarkingView> tempExpr = new LinkedList<MarkingView>();

	public void updateWeight() {
		// TODO Auto-generated method stub
		for(int i=0;i<inputtedWeights.size();i++){
			inputtedWeights.get(i).setText(_arcView.getWeightOfTokenClass(inputtedWeights.get(i).getName())+"");
		}
	}

	public void setWeight(String func, String id) {
		for(int i=0;i<inputtedTokenClassNames.size();i++){
			if(inputtedTokenClassNames.get(i).equals(id)){
				inputtedWeights.get(i).setText(func);
			}
		}
//		
//		for(MarkingView expr: tempExpr){
//			if(expr.getToken().getID().equals(id)){
//				expr.setCurrentMarking(func);
//			}
//		}
	}

}
