package fiji.plugin.trackmate.gui;

import static fiji.plugin.trackmate.gui.TrackMateFrame.SMALL_FONT;
import static fiji.plugin.trackmate.gui.TrackMateFrame.TEXTFIELD_DIMENSION;

import java.util.List;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fiji.plugin.trackmate.features.spot.BlobDescriptiveStatistics;
import fiji.plugin.trackmate.util.TMUtils;

public class JPanelFeatureRatioThreshold extends javax.swing.JPanel {

	private static final long serialVersionUID = 3848390144561204540L;
	private JComboBox jComboBoxFeature;
	private JNumericTextField jTextFieldFeatureRatio;
	private final List<String> features;
	private Map<String, String> featureNames;

	public JPanelFeatureRatioThreshold(List<String> features, Map<String, String> featureNames) {
		super();
		this.features = features;
		this.featureNames = featureNames;
		initGUI();
	}
	
	/*
	 * PUBLIC METHODS
	 */
	
	public String getSelectedFeature() {
		return features.get(jComboBoxFeature.getSelectedIndex());
	}
	
	public double getRatioThreshold() {
		return Double.parseDouble(jTextFieldFeatureRatio.getText());
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		jComboBoxFeature.setEnabled(enabled);
		jTextFieldFeatureRatio.setEnabled(enabled);
	}
	
	/*
	 * PRIVATE METHODS
	 */
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(280, 40));
			this.setSize(280, 40);
			this.setLayout(null);
			{
				ComboBoxModel jComboBoxFeatureModel = new DefaultComboBoxModel(
						TMUtils.getArrayFromMaping(features, featureNames).toArray(new String[] {}));
				jComboBoxFeature = new JComboBox();
				this.add(jComboBoxFeature);
				jComboBoxFeature.setModel(jComboBoxFeatureModel);
				jComboBoxFeature.setBounds(12, 4, 214, 22);
				jComboBoxFeature.setFont(SMALL_FONT);
			}
			{
				jTextFieldFeatureRatio = new JNumericTextField();
				this.add(jTextFieldFeatureRatio);
				jTextFieldFeatureRatio.setText("1.0");
				jTextFieldFeatureRatio.setBounds(238, 4, 30, 22);
				jTextFieldFeatureRatio.setSize(TEXTFIELD_DIMENSION);
				jTextFieldFeatureRatio.setFont(SMALL_FONT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * MAIN METHOD
	 */
	

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JPanelFeatureRatioThreshold(
				BlobDescriptiveStatistics.FEATURES,
				BlobDescriptiveStatistics.FEATURE_NAMES
				));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	

}
