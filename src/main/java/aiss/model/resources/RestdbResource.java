package aiss.model.resources;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import aiss.model.restdb.Restdb;


public class RestdbResource {

	public static boolean addCommentary (String nombre, String mensaje, String pelicula) throws IOException {
		boolean success = true;
		
		try {
			HttpClient cliente = new DefaultHttpClient();
			HttpPost posting = new HttpPost("https://filmaiss-a484.restdb.io/rest/comments");
			StringEntity parametros = new StringEntity("{\"Nombre\":\""+nombre+"\",\"Mensaje\":\""+ mensaje +"\",\"Pelicula\":\""+ pelicula +"\"}");
			posting.addHeader("content-type", "application/json");
			posting.addHeader("x-apikey", "9ab6c8c0a86ba9e8250b46c2bb728d48d36e2");
			posting.setEntity(parametros);
			
			HttpResponse respuesta = cliente.execute(posting);
		} catch (Exception e) {
			success = false;
		}
		
		return success;
	}
	
	private static final Logger log = Logger.getLogger(IMDbResource.class.getName());

	public static List<Restdb> getComments(String titulo) throws ParseException, IOException {
		//String queryFormatted = URLEncoder.encode(titulo, "UTF-8");
		String tituloCodificado = Base64.getEncoder().encodeToString(titulo.getBytes());
		String uri = "https://filmaiss-a484.restdb.io/rest/comments?apikey=9ab6c8c0a86ba9e8250b46c2bb728d48d36e2&q=%7B%22Pelicula%22:%22" + tituloCodificado + "%22%7D";
		
		log.log(Level.FINE, "Restdb URI: " + uri);
		
		boolean success = true;
			List<Restdb> res = new ArrayList<>();
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet request = new HttpGet (uri);
			
			HttpResponse response = httpclient.execute(request);
			String result =  EntityUtils.toString(response.getEntity());
			//Object[] arrayLs = result.substring(2, result.length()-2);
			Scanner sc = new Scanner(result.substring(2, result.length()-2));
			List<String> arrayLs = new ArrayList<String>();
			while (sc.hasNext()) {
				String line = sc.nextLine();
				arrayLs.add(line);
				
			}
			
			for (int i = 0; i < arrayLs.size(); i++) {
				String linea;
				if(i==arrayLs.size()-1) {
					linea = arrayLs.get(i).toString().substring(2, arrayLs.get(i).toString().length()-1);
					String[] line = linea.split(",");
					byte[] decodedMessage = Base64.getDecoder().decode(line[2].substring(11, line[2].length()-1));
					Restdb rb = new Restdb(line[0].substring(7, line[0].length()-1), line[1].substring(10, line[1].length()-1), new String(decodedMessage), line[3].substring(12, line[3].length()-1));
					res.add(rb);
				} else {
					linea = arrayLs.get(i).toString().substring(2, arrayLs.get(i).toString().length()-2);
					String[] line = linea.split(",");
					byte[] decodedMessage = Base64.getDecoder().decode(line[2].substring(11, line[2].length()-1));
					Restdb rb = new Restdb(line[0].substring(7, line[0].length()-1), line[1].substring(10, line[1].length()-1), new String(decodedMessage), line[3].substring(12, line[3].length()-1));
					res.add(rb);
				}
			}
			
			
		
		return res;
		
	} 
	
	public static void main(String[] args) throws ParseException, IOException {
		for (int i = 0; i < getComments("Avengers: Endgame").size(); i++) {
			System.out.println(getComments("Avengers: Endgame").get(i).getMensaje());
		}
	}
	
}
