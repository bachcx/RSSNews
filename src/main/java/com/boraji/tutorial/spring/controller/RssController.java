package com.boraji.tutorial.spring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.boraji.tutorial.spring.model.Article;
import com.boraji.tutorial.spring.model.Rss;

@Controller
public class RssController {
	
	@ModelAttribute("rss")
	public Rss createRssModel() {
		return new Rss();
	}
	
	@RequestMapping(value = "/addRss", method = RequestMethod.GET)
	public ModelAndView rss(Model model) {
		model.addAttribute("getFlag", true);		
		return new ModelAndView("add", "command", new Rss());
	}
	
	@RequestMapping(value = "/addRss", method = RequestMethod.POST)
	public String addRss(@ModelAttribute("rss") Rss rss, BindingResult bindingResult, Model model) {
		MyController myControl = new MyController();
		ArrayList<Article> articleList = myControl.getArticleFromRSS(rss.getLinkRss());
		model.addAttribute("articleList", articleList);		
		return "add";
	}
}
