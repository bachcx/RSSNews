package com.boraji.tutorial.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String getRss(@RequestParam("url") String url,  Model model) {
		MyController myControl = new MyController();
		ArrayList<Article> articleList = myControl.getArticleFromRSS(url);
		model.addAttribute("list", rssService.list());
		model.addAttribute("articleList", articleList);		
		return "add";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	@ResponseBody
	public String removeRss(@RequestParam("id") int id) {
		String txt = "";
		if(rssService.remove(id)) {
			txt = "OK";
		} else {
			txt = "NG";
		}
		return txt;
		
	}
}

