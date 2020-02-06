package example;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class GetIPInfo extends JFrame {

	private JPanel contentPane;
	JTextField IP;
	private String API_KEYS = "8d5c92fee1b8a5a083402a054f588e45";
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private URL url;
	private HttpURLConnection urlc;
	private BufferedReader br;
	private StringBuffer sb;
	private JSeparator separator;
	private JLabel iplbl;
	private JLabel lblType;
	private JLabel lblContinent;
	private JLabel lblCountry;
	private JLabel lblRegion;
	private JLabel lblCity;
	private JLabel lblZipCode;
	private JLabel lblLatitude;
	private JLabel lblLongitude;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel ipboxlbl;
	private JLabel typeboxlbl;
	private JLabel continentboxlbl;
	private JLabel countryboxlbl;
	private JLabel regionboxlbl;
	private JLabel cityboxlbl;
	private JLabel zipcodelbl;
	private JLabel latituseboxlbl;
	private JLabel longitudeboxlbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetIPInfo frame = new GetIPInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */

	private void connect() throws IOException {

		url = new URL("http://api.ipstack.com/" + IP.getText() + "?access_key=" + API_KEYS);
		urlc = (HttpURLConnection) url.openConnection();

	}

	private void storeData() throws IOException {

		br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
		String s;
		sb = new StringBuffer();
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}
		
	}

	private void getData() throws IOException {
		connect();
		storeData();
		Object obj = JSONValue.parse(sb.toString());
		JSONObject jo = (JSONObject) obj;
		ipboxlbl.setText((String) jo.get("ip"));
		typeboxlbl.setText((String) jo.get("type"));
		continentboxlbl.setText((String) jo.get("continent_name") + " , " + jo.get("continent_code"));
		countryboxlbl.setText((String) jo.get("country_name") + " , " + jo.get("country_code"));
		regionboxlbl.setText((String) jo.get("region_name") + " , " + jo.get("region_code"));
		cityboxlbl.setText((String) jo.get("city"));
		zipcodelbl.setText((String) jo.get("zip"));
		double lat = (Double) jo.get("latitude");
		double longi = (Double) jo.get("longitude");
		latituseboxlbl.setText(String.valueOf(lat));
		longitudeboxlbl.setText(String.valueOf(longi));

	}

	public GetIPInfo() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 284);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel enterIpLbl = new JLabel("Enter IP ");
		enterIpLbl.setFont(new Font("SansSerif", Font.PLAIN, 14));
		enterIpLbl.setBounds(45, 27, 67, 19);
		contentPane.add(enterIpLbl);

		IP = new JTextField();
		IP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						
						getData();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		IP.setBounds(21, 57, 103, 20);
		contentPane.add(IP);

		JPanel panel = new JPanel();
		panel.setBounds(143, 0, 393, 257);
		contentPane.add(panel);
		panel.setLayout(null);

		iplbl = new JLabel("IP");
		iplbl.setBounds(10, 46, 15, 14);
		panel.add(iplbl);

		lblType = new JLabel("TYPE");
		lblType.setBounds(10, 63, 30, 14);
		panel.add(lblType);

		lblContinent = new JLabel("CONTINENT");
		lblContinent.setBounds(10, 79, 96, 14);
		panel.add(lblContinent);

		lblCountry = new JLabel("COUNTRY");
		lblCountry.setBounds(10, 97, 96, 14);
		panel.add(lblCountry);

		lblRegion = new JLabel("REGION");
		lblRegion.setBounds(10, 116, 96, 14);
		panel.add(lblRegion);

		lblCity = new JLabel("CITY");
		lblCity.setBounds(10, 136, 96, 14);
		panel.add(lblCity);

		lblZipCode = new JLabel("ZIP CODE");
		lblZipCode.setBounds(10, 153, 96, 14);
		panel.add(lblZipCode);

		lblLatitude = new JLabel("LATITUDE");
		lblLatitude.setBounds(10, 170, 96, 14);
		panel.add(lblLatitude);

		lblLongitude = new JLabel("LONGITUDE");
		lblLongitude.setBounds(10, 190, 96, 14);
		panel.add(lblLongitude);

		label = new JLabel(":");
		label.setBounds(116, 46, 15, 14);
		panel.add(label);

		label_1 = new JLabel(":");
		label_1.setBounds(116, 63, 15, 14);
		panel.add(label_1);

		label_2 = new JLabel(":");
		label_2.setBounds(116, 79, 15, 14);
		panel.add(label_2);

		label_3 = new JLabel(":");
		label_3.setBounds(116, 97, 15, 14);
		panel.add(label_3);

		label_4 = new JLabel(":");
		label_4.setBounds(116, 116, 15, 14);
		panel.add(label_4);

		label_5 = new JLabel(":");
		label_5.setBounds(116, 136, 15, 14);
		panel.add(label_5);

		label_6 = new JLabel(":");
		label_6.setBounds(116, 153, 15, 14);
		panel.add(label_6);

		label_7 = new JLabel(":");
		label_7.setBounds(116, 170, 15, 14);
		panel.add(label_7);

		label_8 = new JLabel(":");
		label_8.setBounds(116, 190, 15, 14);
		panel.add(label_8);

		ipboxlbl = new JLabel("");
		ipboxlbl.setBounds(141, 46, 242, 14);
		panel.add(ipboxlbl);

		typeboxlbl = new JLabel("");
		typeboxlbl.setBounds(141, 63, 242, 14);
		panel.add(typeboxlbl);

		continentboxlbl = new JLabel("");
		continentboxlbl.setBounds(141, 79, 242, 14);
		panel.add(continentboxlbl);

		countryboxlbl = new JLabel("");
		countryboxlbl.setBounds(141, 97, 242, 14);
		panel.add(countryboxlbl);

		regionboxlbl = new JLabel("");
		regionboxlbl.setBounds(141, 116, 242, 14);
		panel.add(regionboxlbl);

		cityboxlbl = new JLabel("");
		cityboxlbl.setBounds(141, 136, 242, 14);
		panel.add(cityboxlbl);

		zipcodelbl = new JLabel("");
		zipcodelbl.setBounds(141, 153, 242, 14);
		panel.add(zipcodelbl);

		latituseboxlbl = new JLabel("");
		latituseboxlbl.setBounds(141, 170, 242, 14);
		panel.add(latituseboxlbl);

		longitudeboxlbl = new JLabel("");
		longitudeboxlbl.setBounds(141, 190, 242, 14);
		panel.add(longitudeboxlbl);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(135, 0, 2, 315);
		contentPane.add(separator);
	}
}
