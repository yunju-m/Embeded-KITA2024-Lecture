package javabasic.oop.lotto;

public interface ILottoRank {
	
	public abstract String getLottoRank();
	public int countSameLottoNumbers();
	public boolean sameLastLottoNumber();
	public void calculateLottoRank();
	
}
