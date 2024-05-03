package javabasic.oop;

public interface IMonitor {

	public static final int INCH_TWENTY_FOUR = 24;
	public static final int INCH_THIRTY = 30;
	public static final int INCH_FOURTY = 40;
	
	public abstract void powerOn();		// 메소드 시그니쳐
	public abstract void powerOff();
	public abstract void brightUp();
	public abstract void brightDown();
	
}
