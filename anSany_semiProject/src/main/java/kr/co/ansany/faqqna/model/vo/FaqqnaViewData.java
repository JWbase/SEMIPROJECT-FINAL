package kr.co.ansany.faqqna.model.vo;

public class FaqqnaViewData {
	private Faqqna f;
	private FaqqnaComment fc;
	public FaqqnaViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public FaqqnaViewData(Faqqna f, FaqqnaComment fc) {
		super();
		this.f = f;
		this.fc = fc;
	}

	public Faqqna getF() {
		return f;
	}
	public void setF(Faqqna f) {
		this.f = f;
	}
	public FaqqnaComment getFc() {
		return fc;
	}
	public void setFc(FaqqnaComment fc) {
		this.fc = fc;
	}
	
	
}
