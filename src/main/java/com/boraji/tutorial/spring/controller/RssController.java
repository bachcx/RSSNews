package com.boraji.tutorial.spring.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.boraji.tutorial.spring.model.Article;
import com.boraji.tutorial.spring.model.Rss;
import com.boraji.tutorial.spring.service.RssService;




@Controller
public class RssController {
	
	private static final Logger LOGGER = LogManager.getLogger(RssController.class.getName());
    
	@Autowired
	private RssService rssService;

	@ModelAttribute("rss")
	public Rss createRssModel() {
		return new Rss();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView rss(Model model) {
		model.addAttribute("list", rssService.list());
		model.addAttribute("getFlag", true);
		return new ModelAndView("add", "command", new Rss());
	}

	@RequestMapping(value = "/addRss", method = RequestMethod.POST)
	public String addRss(@ModelAttribute("rss") Rss rss, BindingResult bindingResult, Model model) {
		MyController myControl = new MyController();
		ArrayList<Article> articleList = myControl.getArticleFromRSS(rss, rssService);
		model.addAttribute("list", rssService.list());
		model.addAttribute("articleList", articleList);
		return "add";
	}

	@RequestMapping(value = "/getFeed", method = RequestMethod.GET)
	public String getRss(@RequestParam("url") String url, Model model) {
		MyController myControl = new MyController();
		ArrayList<Article> articleList = myControl.getArticleFromRSS(url);
		model.addAttribute("list", rssService.list());
		model.addAttribute("articleList", articleList);
		return "add";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@ResponseBody
	public String removeRss(@RequestParam("id") int id) {
		String txt = "";
		if (rssService.remove(id)) {
			txt = "OK";
		} else {
			txt = "NG";
		}
		return txt;

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(ModelMap model) {
		MyController myControl = new MyController();
		List<Rss> list = rssService.list();
		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			model.addAttribute("urlSelected", list.get(0).getLinkRss());
			model.addAttribute("articleList1", myControl.getArticleFromRSS(list.get(0).getLinkRss()));
		} else {
			LOGGER.debug("Haven't articel");
		}
		return "index";
	}

	@RequestMapping(value = "/getFeed2", method = RequestMethod.GET)
	public String index(@RequestParam("url") String url, ModelMap model) {
		MyController myControl = new MyController();
		List<Rss> list = rssService.list();
		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			try {
				url = URLEncoder.encode(url, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				LOGGER.debug(e.getMessage());
		        e.printStackTrace();
			}
			model.addAttribute("urlSelected", url);
			model.addAttribute("articleList1", myControl.getArticleFromRSS(url));
		}
		return "index";
	}
}
