package com.boraji.tutorial.spring.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boraji.tutorial.spring.model.Article;
import com.boraji.tutorial.spring.model.Rss;
import com.boraji.tutorial.spring.service.RssService;

@Controller
public class MyController {
	
	@RequestMapping("/home")
	public String index(ModelMap model) {
		model.addAttribute("articleList1", getArticleFromRSS("https://tinhte.vn/rss"));
		model.addAttribute("articleList2", getArticleFromRSS("https://vnexpress.net/rss/tin-moi-nhat.rss"));
		model.addAttribute("articleList3", getArticleFromRSS("https://vnexpress.net/rss/thoi-su.rss"));
		return "index";
	}

	public ArrayList<Article> getArticleFromRSS(String urlStr) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		// BufferedReader
		BufferedReader reader = null;

		try {
			// URL and connection to get data
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "RssNews");

			// Get reader from connection
			while (reader == null) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			}
			String rpData = "";
			StringBuffer buffer = new StringBuffer();

			// Get data from buffer reader
			while (null != (rpData = reader.readLine())) {
				buffer.append(rpData);
			}

			String data = buffer.toString();
			SAXBuilder builder = new SAXBuilder();

			try {
				InputStream stream = new ByteArrayInputStream(data.getBytes("UTF-8"));
				Document doc = builder.build(stream);
				// rss
				Element rootNode = doc.getRootElement();
				// list item
				List<Element> list = rootNode.getChildren().get(0).getChildren("item");
				articleList = parseData(list);
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return articleList;
	}

	public ArrayList<Article> getArticleFromRSS(Rss rss, RssService rssService) {

		ArrayList<Article> articleList = new ArrayList<Article>();
		// BufferedReader
		BufferedReader reader = null;

		try {
			// URL and connection to get data
			URL url = new URL(rss.getLinkRss());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "RssNews");

			// Get reader from connection
			while (reader == null) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			}

			String rpData = "";
			StringBuffer buffer = new StringBuffer();

			// Get data from buffer reader
			while (null != (rpData = reader.readLine())) {
				buffer.append(rpData);
			}

			String data = buffer.toString();
			SAXBuilder builder = new SAXBuilder();

			try {
				InputStream stream = new ByteArrayInputStream(data.getBytes("UTF-8"));
				Document doc = builder.build(stream);
				// rss
				Element rootNode = doc.getRootElement();
				// Save Rss
				if (!rssService.exists(rss)) {
					rss.setLinkRss(URLEncoder.encode(rss.getLinkRss(), "UTF-8"));
					rss.setNameRss(rootNode.getChildren().get(0).getChildText("title"));
					rssService.save(rss);
					// decode to view
					rss.setLinkRss(URLDecoder.decode(rss.getLinkRss(), "UTF-8"));
				} else {

				}

				// list item
				List<Element> list = rootNode.getChildren().get(0).getChildren("item");
				articleList = parseData(list);
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return articleList;
	}

	public ArrayList<Article> test(String urlStr) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		// BufferedReader
		BufferedReader reader = null;
		try {
			// URL and connection to get data
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "RssNews");

			// Get reader from connection
			while (reader == null) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			}

			String rpData = "";
			StringBuffer buffer = new StringBuffer();

			// Get data from buffer reader
			while (null != (rpData = reader.readLine())) {
				buffer.append(rpData);
			}

			String data = buffer.toString();

			SAXBuilder builder = new SAXBuilder();

			try {
				InputStream stream = new ByteArrayInputStream(data.getBytes("UTF-8"));
				Document doc = builder.build(stream);
				// rss
				Element rootNode = doc.getRootElement();
				// list item
				List<Element> list = rootNode.getChildren().get(0).getChildren("item");

				articleList = parseData(list);
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception ex) {

		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return articleList;
	}

	public ArrayList<Article> parseData(List<Element> list) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		for (int i = 0; i < list.size(); i++) {
			Element node = list.get(i);
			Article newArticle = new Article();
			newArticle.setTitle(node.getChildText("title"));
			newArticle.setLink(node.getChildText("link"));
			newArticle.setPubDate(node.getChildText("pubDate"));

			Namespace content = null;
			String contentEncode = "";
			contentEncode = node.getChildText("encoded", content);
			
			String description = "";
			description = node.getChildText("description");
			
			Pattern p = Pattern.compile("src=\"(.*?)\"");
			
			Matcher m = null;
			Matcher m1 = null;
			Matcher m2 = null;
			if (description != null) m1 = p.matcher(description);
			if(contentEncode != null) m2 = p.matcher(contentEncode);
			
			if(description != null && !description.equals("")) {
				contentEncode = description;
			}
			
			if (m1 != null && m1.find()) {
				m = m1;
			} else if (m2 != null && m2.find()) {
				m = m2;
			}
				
			if (m != null) {
				String[] tokens = m.group(1).split("\\.(?=[^\\.]+$)");
				if ((tokens[1] != null) && (tokens[1].equals("jpg") || tokens[1].equals("png")
						|| tokens[1].equals("gif") || tokens[1].equals("jpeg"))) {
					newArticle.setVideoFlag(false);
					newArticle.setMediaLink(m.group(1));
				} else if (tokens[1] != null) {
					newArticle.setVideoFlag(true);
					newArticle.setMediaLink(m.group(1));
					System.out.println(m.group(1));
				}
			}
			newArticle.setContentEncode(contentEncode);
			
			String shortContent = Jsoup.clean(contentEncode, "", Whitelist.none().addTags("br", "p"),
					new OutputSettings().prettyPrint(true));
			newArticle.setShortContent(shortContent);
			articleList.add(newArticle);
		}
		return articleList;
	}
}
