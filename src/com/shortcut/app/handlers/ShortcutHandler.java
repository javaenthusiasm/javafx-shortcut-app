package com.shortcut.app.handlers;

import com.shortcut.app.utils.CustomKeyCombination;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class ShortcutHandler implements EventHandler<KeyEvent> {
	
	private CustomKeyCombination shortcut;
	private Runnable runnable;
	
	public ShortcutHandler(CustomKeyCombination shortcut, Runnable runnable) {
		this.shortcut = shortcut;
		this.runnable = runnable;
	}
	
	@Override
	public void handle(KeyEvent event) {
		if(shortcut.match(event)) {
			runnable.run();
		}
	}

}
