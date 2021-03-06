/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unizh.ini.jaer.chip.dvs320;

import java.awt.BorderLayout;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.swing.JPanel;
import net.sf.jaer.chip.AEChip;
import net.sf.jaer.graphics.AEViewer;

/**
 * Displays data from CDVS chips.
 * @author Tobi
 */
public class cDVSTest30DisplayMethod extends DVSWithIntensityDisplayMethod {

    private cDVSTest30 cDVSChip = null;
    boolean registeredControlPanel = false;
    private cDVSTest30OutputControlPanel controlPanel = null;

    public cDVSTest30DisplayMethod(cDVSTest30 chip) {
        super(chip.getCanvas());
        this.cDVSChip = chip;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        GL gl=drawable.getGL();
        gl.glLineWidth(2f);
        gl.glColor3f(1,1,1);
        // draw boxes around arrays

       rect(gl,0,0,64,64);
       rect(gl,64,0,32,32);
       rect(gl,96,0,32,32);
       rect(gl,96,32,32,32);
       rect(gl,64,32,32,32);
       rect(gl,140,0,2,64);

    }

    private void rect(GL gl, float x, float y, float w, float h){
        gl.glLineWidth(2f);
        gl.glColor3f(1,1,1);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2f(x,y);
        gl.glVertex2f(x+w,y);
        gl.glVertex2f(x+w,y+h);
        gl.glVertex2f(x,y+h);
        gl.glEnd();
    }

     public void setDisplayLogIntensityChangeEvents(boolean displayLogIntensityChangeEvents) {
        cDVSChip.setDisplayLogIntensityChangeEvents(displayLogIntensityChangeEvents);
    }

    public void setDisplayLogIntensity(boolean displayLogIntensity) {
        cDVSChip.setDisplayLogIntensity(displayLogIntensity);
    }

    public void setDisplayColorChangeEvents(boolean displayColorChangeEvents) {
        cDVSChip.setDisplayColorChangeEvents(displayColorChangeEvents);
    }

    public boolean isDisplayLogIntensityChangeEvents() {
        return cDVSChip.isDisplayLogIntensityChangeEvents();
    }

    public boolean isDisplayLogIntensity() {
        return cDVSChip.isDisplayLogIntensity();
    }

    public boolean isDisplayColorChangeEvents() {
        return cDVSChip.isDisplayColorChangeEvents();
    }
}
