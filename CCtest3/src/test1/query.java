package test1;

import java.io.*;
import java.util.ArrayList;  
import java.util.List;
import java.util.Map;

import twitter4j.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;  
import java.util.List;  
import test1.PrintSampleStream;


public class query extends HttpServlet {
	public static String queryResults;
	public static PrintWriter out;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public query() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintSampleStream ps = new PrintSampleStream();
		List<Map<String,Object>> tweet = new ArrayList<Map<String,Object>>();
		try {
			 ps.hahaha();
			 tweet = ps.tweets;
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//query(content);
		//queryResults=queryTweets.query(content);
		//System.out.println(queryResults);
		//String fp = getServletContext().getRealPath("/output.txt");
		
		//FileReader fr = new FileReader(fp);
		//char []buf = new char[1024];  
        //int len = 0;  
		
		
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
        try {
        	out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        	out.println("<style type=\"text/css\">html, body { height: 100%; margin: 0; padding: 0; }#map { height: 100%; }</style><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>qnmd</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"map\"></div>");
            out.println(" <script type=\"text/javascript\">");
            out.println("var map;");
            out.println("function initMap() {");
            out.println("map = new google.maps.Map(document.getElementById(\'map\'), {");
            out.println("center: {lat: 40.75, lng: -73.97},");
            out.println("zoom: 13");
            out.println( "});");
            for(int i = 0;i<1;i++){
            	out.println("var text = "+"'"+"<div id = \"content\">"+"'+"+"'"+"<h1 id=\"firstHeading\" class=\"firstHeading\">"+tweet.get(i).get("username")+"</h1>"+"'+"+"'<div id=\"bodyContent\">'+"+"'<p>"+tweet.get(i).get("text").toString().replaceAll("'", "").replaceAll("\n","")+"</p>'+"+"'</div>'+'</div>';");
            	out.println("var "+"infowindow = new google.maps.InfoWindow({"
            	+"content: text"
            	+"});");
            	out.println("var "+"pos= "+"{lat:"+tweet.get(i).get("latitude")+", lng:"+tweet.get(i).get("longitude")+"};");
            	out.println("var "+"marker = new google.maps.Marker({\n"
            	+"position:pos,\n"
            	+"map: map,\n"
            	+"title:"+"'"+tweet.get(i).get("username")+"'"
            	+"\n  });");
            	out.println("marker.addListener('click', function() {"
            			+"infowindow.open(map, marker);"
            			+"});");
            }
            out.println("}");
            out.println("</script>");
            out.println("<script async defer");
            out.println("src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCIJD7A3zp5eJtYnESkIGpZN6yIPSe8iG8&callback=initMap\">");
            out.println("</script>");
            /*for(int i = 0;i<1;i++){
            	out.println(tweet.get(i).get("username"));
            }*/
            out.println("</body>");
            out.println("</html>");
		} finally {
            out.close();
        }
	}			
	

}