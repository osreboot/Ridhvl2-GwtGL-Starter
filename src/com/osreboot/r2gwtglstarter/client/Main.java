package com.osreboot.r2gwtglstarter.client;

import com.google.gwt.core.client.Duration;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.osreboot.ridhvl2.HvlLogger;
import com.osreboot.ridhvl2.HvlMath;
import com.osreboot.ridhvl2.template.HvlDisplay;
import com.osreboot.ridhvl2.template.HvlDisplayEmbedded;
import com.osreboot.ridhvl2.template.HvlTemplateI;

public class Main extends HvlTemplateI{
	
	public Main(){
		super(new HvlDisplayEmbedded(144, 1280, 720, "ridhvl2_gwtgl_starter"), Long.MAX_VALUE, Long.MAX_VALUE);
	}
	
	@Override
	public void initialize(){
		HvlLogger.println(Ridhvl2_GwtGL_Starter.class, "TEST " + HvlDisplay.getDisplay().getRefreshRate());
		
		HvlDisplay.getDisplay().getGLContext().viewport(0, 0, 1280, 720);
		HvlDisplay.getDisplay().getGLContext().clearColor(1f, 0f, 1f, 1f);
	}

	@Override
	public void update(float delta){
		HvlLogger.println(Ridhvl2_GwtGL_Starter.class, delta + "");
		
		HvlDisplay.getDisplay().getGLContext().clearColor(1f, HvlMath.map((float)Math.cos(Duration.currentTimeMillis() / 1000f), -1f, 1f, 0f, 1f), 1f, 1f);
		HvlDisplay.getDisplay().getGLContext().clear(WebGLRenderingContext.COLOR_BUFFER_BIT);
	}

}
