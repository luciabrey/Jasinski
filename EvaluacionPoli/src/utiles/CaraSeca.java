package utiles;

public enum CaraSeca {
	CARA,
	SECA;
	static CaraSeca maq;
	
	public static CaraSeca tirarMoneda() {
		int res = Utiles.generarRandom(1, 2);
		if(res == 1) {
			maq = CaraSeca.CARA;
		} else if(res == 2) {
			maq = CaraSeca.SECA;
		}
		return maq;
	}
}
