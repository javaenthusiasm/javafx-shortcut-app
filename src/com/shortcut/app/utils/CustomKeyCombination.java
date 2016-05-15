package com.shortcut.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

public class CustomKeyCombination extends KeyCombination {
	
	
	private static List<KeyCode> neededSequence; // defined sequence
	private List<KeyCode> currentSequence = new ArrayList<KeyCode>();  // pressed sequence in keyboard
	
	public CustomKeyCombination(Modifier modifier, KeyCode... codes) {
		super(modifier);
		neededSequence = Arrays.asList(codes);
	}
	
	@Override
	public boolean match(KeyEvent event) {
		if(super.match(event)) {
			currentSequence.add(event.getCode());
			if(currentSequence.equals(neededSequence)) {
				currentSequence.clear();
				return true;
			}
			if(!checkSequence(currentSequence)) {
				currentSequence.clear();
				return false;
			}
		}
		return false;
	}
	
	private boolean checkSequence(List<KeyCode> sequence) {
		for (int i=0;i<sequence.size();i++) {
			if(sequence.get(i) != neededSequence.get(i)) {
				return false;
			}
		}
		return true;
	}
}