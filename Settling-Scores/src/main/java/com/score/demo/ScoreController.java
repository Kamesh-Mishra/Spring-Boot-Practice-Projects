package com.score.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ScoreController {

	static Score score = new Score(30,20,10);
	
	@GetMapping("/health-check")
	public String getHealthCheck() {
		return "Situation Normal All Fired Up!";
	}
	
	
	@GetMapping("/score")
	public Score getScore() {
		return score;
	}
	
	@GetMapping("/score/{winslossesorties}")
	public int getWinsLossesOrTies(@PathVariable String winslossesorties) {
		if(winslossesorties.equals("wins"))
			return score.wins;
		if(winslossesorties.equals("ties"))
			return score.ties;
		return score.losses;
	}
	
	
	@PostMapping("/score/wins")
	public Score increaseWins() {
		score.wins++;
		return score;
	}
	
	@PostMapping("/score/ties")
	public Score increaseTies() {
		score.ties++;
		return score;
	}
	
	@PostMapping("/score/losses")
	public Score increaseLosses() {
		score.losses++;
		return score;
	}
	
	@PutMapping("/score")
	public Score deleteScore(@RequestBody Score newScore) {
		score = newScore;
		return score;
	}
	
	@DeleteMapping("/score")
	public void deleteScore() {
		score = null;
	}
	
	@PatchMapping("/score/wins")
	public Score updateWins(@RequestParam("new-value") int newValue) {
		score.wins = newValue;
		return score;
	}
	
	
	
	
}
