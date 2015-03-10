package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.konka.dhtsearch.db.luncene.LuceneUtils;
import com.konka.dhtsearch.db.models.DhtInfo_MongoDbPojo;

public class DetailsServlet extends HttpServlet{

	private static final long serialVersionUID = -5212364653692205765L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String info_hash=request.getParameter("info_hash");
		try {
			DhtInfo_MongoDbPojo dhtInfo_MongoDbPojo=LuceneUtils.searchByInfoHash(info_hash);
			request.setAttribute("dhtInfo_MongoDbPojo", dhtInfo_MongoDbPojo);
			request.getRequestDispatcher("/Details.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

}