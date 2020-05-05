package com.osreboot.r2gwtglstarter.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.osreboot.ridhvl2.HvlMath;

public class Ridhvl2_GwtGL_Starter implements EntryPoint{

	public void onModuleLoad(){
		try{
			RootPanel.get("ridhvl2_gwtgl_starter").add(new Ridhvl2_GwtGL_Starter().getWidget());
		}catch(Exception e){
			Window.alert("Fatal Error: " + e.getMessage());
		}
	}

	protected final Canvas canvas;
	protected final WebGLRenderingContext glContext;

	public Ridhvl2_GwtGL_Starter(){
		canvas = Canvas.createIfSupported();
		canvas.setCoordinateSpaceWidth(512);
		canvas.setCoordinateSpaceHeight(512);
		glContext = (WebGLRenderingContext)canvas.getContext("webgl");
		if(glContext == null){
			Window.alert("Fatal Error: WebGL not supported!");
		}else{
			glContext.viewport(0, 0, 512, 512);
			glContext.clearColor(1f, 0f, 1f, 1f);
			Timer timer = new Timer(){
				@Override
				public void run(){
					glContext.clearColor(1f, HvlMath.map((float)Math.random(), 0f, 1f, 0f, 0.5f), 1f, 1f);
					glContext.clear(WebGLRenderingContext.COLOR_BUFFER_BIT);
				}
			};
			timer.scheduleRepeating(20);
		}
	}

	public Widget getWidget(){
		return canvas;
	}

}
