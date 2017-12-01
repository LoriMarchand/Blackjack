package com.lmig.gfc.blackjack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.blackjack.models.*;

@Controller
public class GameController {

	private Game game;

	public GameController() {
		game = new Game();

	}

	@GetMapping("/")
	public ModelAndView defaultPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bet");
		return mv;
	}

	@GetMapping("/play")
	public ModelAndView showPlayScreen() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("play");
		mv.addObject("game", game);
		return mv;

	}

	@PostMapping("/bet")
	public ModelAndView handleBet(int bet) {
		game.deal();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/play");
		return mv;

	}

	@PostMapping("/hit")
	public ModelAndView handleHit() {
		game.hitPlayer();
		ModelAndView mv = new ModelAndView();
	
		if (game.playerHasMoreThan21()) {
			mv.setViewName("redirect:/busted");
		} else {
			mv.setViewName("redirect:/play");
		}
		return mv;
	}

	@GetMapping("/busted")
	public ModelAndView bustedPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("busted");
		return mv;
	}

	@PostMapping("/stand")
	public ModelAndView standPage() {
		game.hitDealer();
		ModelAndView mv = new ModelAndView();

		if (game.dealerHasMoreThan21()) {
			mv.setViewName("redirect:/busted");
		} else {
			mv.setViewName("redirect:/play");
		}
		return mv;
	}
}
