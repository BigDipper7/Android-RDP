

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

import org.w3c.dom.css.Rect;

public class RobotHelper {
	private static final int customMS = 10;
	
	/**
     * ��굥���������,Ҫ˫������������
     * 
     * @param robot
     * @param x
     *            x����λ��
     * @param y
     *            y����λ��
     * @param delay
     *            �ò�������ӳ�ʱ��
     */
	public static void cilckLMouse(Robot robot, int x, int y, int delay) {
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.delay(customMS);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(delay);
	}
	
	/**
     * ����һ�,Ҫ˫������������
     * 
     * @param robot
     * @param x
     *            x����λ��
     * @param y
     *            y����λ��
     * @param delay
     *            �ò�������ӳ�ʱ��
     */
	public static void clickRMouse(Robot robot, int x, int y, int delay) {
		robot.mouseMove(x, y);
		robot.mousePress(InputEvent.BUTTON2_MASK);
		robot.delay(customMS);
		robot.mouseRelease(InputEvent.BUTTON2_MASK);
		robot.delay(delay);
	}
	
	/**
     * �������루һ��ֻ������һ���ַ���
     * 
     * @param r
     * @param ks
     *            ����������ַ�����
     * @param delay
     *            ����һ��������ӳ�ʱ��
     */
	public static void pressKey(Robot robot, int[] keys, int delay) {
		for(int i=0; i<keys.length; i++) {
			robot.keyPress(keys[i]);
			robot.delay(customMS);
			robot.keyRelease(keys[i]);
			robot.delay(delay);
		}
	}
	
	/**
     * ��׽ȫ��Ľ
     * 
     * @param r
     * @return
     */
	public static  BufferedImage captureWholeScreen(Robot robot, int delay) {
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = robot.createScreenCapture(screenRect);
		robot.delay(delay);
		return image;
	}
	
	/**
     * ��׽��Ļ��һ����������
     * 
     * @param r
     * @param x
     *            x����λ��
     * @param y
     *            y����λ��
     * @param width
     *            ���εĿ�
     * @param height
     *            ���εĸ�
     * @return
     */
	public static BufferedImage capturePartScreen(Robot robot, int startX, int startY, int width, int height, int delay) {
		Rectangle screenRect = new Rectangle(startX, startY, width, height);
//		robot.mouseMove(startX, startY);
//		robot.delay(customMS);
//		BufferedImage image = robot.createScreenCapture(new Rectangle(width, height));
		BufferedImage image = robot.createScreenCapture(screenRect);
		robot.delay(delay);
		return image;
	}
}
