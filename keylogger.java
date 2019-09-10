import java.util.Map.Entry;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;

public class GlobalKeyboardExample {
	private static boolean run = true;
	public static void main(String[] args) {
		// might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails 
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true); // use false here to switch to hook instead of raw input
        GlobalMouseHook mouseHook = new GlobalMouseHook();

		System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");
		for(Entry<Long,String> keyboard:GlobalKeyboardHook.listKeyboards().entrySet())
			System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());
		
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override public void keyPressed(GlobalKeyEvent event) {
				System.out.println(event);
				if(event.getVirtualKeyCode()==GlobalKeyEvent.VK_ESCAPE)
					run = false;
			}
			@Override public void keyReleased(GlobalKeyEvent event) {
				System.out.println(event); }
		});
		
		try {
			while(run) Thread.sleep(128);
		} catch(InterruptedException e) { /* nothing to do here */ }
		  finally { keyboardHook.shutdownHook(); }

    System.out.println("Global mouse hook successfully started, press [middle] mouse button to shutdown. Connected mice:");
		for(Entry<Long,String> mouse:GlobalMouseHook.listMice().entrySet())
			System.out.format("%d: %s\n", mouse.getKey(), mouse.getValue());
		
		mouseHook.addMouseListener(new GlobalMouseAdapter() {
			@Override public void mousePressed(GlobalMouseEvent event)  {
				System.out.println(event);
				if((event.getButtons()&GlobalMouseEvent.BUTTON_LEFT)!=GlobalMouseEvent.BUTTON_NO
				&& (event.getButtons()&GlobalMouseEvent.BUTTON_RIGHT)!=GlobalMouseEvent.BUTTON_NO)
					System.out.println("Both mouse buttons are currenlty pressed!");
				if(event.getButton()==GlobalMouseEvent.BUTTON_MIDDLE)
					run = false;
			}
			@Override public void mouseReleased(GlobalMouseEvent event)  {
				System.out.println(event); }
			@Override public void mouseMoved(GlobalMouseEvent event) {
				System.out.println(event); }
			@Override public void mouseWheel(GlobalMouseEvent event) {
				System.out.println(event); }
		});
		
		try {
			while(run) Thread.sleep(128);
		} catch(InterruptedException e) { /* nothing to do here */ }
		  finally { mouseHook.shutdownHook(); }
	}
}