package com.alanlauradavid.model;

public class Material {
	String state;
	String materialType;
	int cuantity;
	int amount;
	int articleId;
	
	public Material () {}
	
	public Material(
			String state,
			String materialType,
			int cuantity,
			int amount,
			int articleId
		)
	{
		this.state		  = state;
		this.materialType = materialType;
		this.cuantity 	  = cuantity;
		this.amount 	  = amount;
		this.articleId	  = articleId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public int getCuantity() {
		return cuantity;
	}

	public void setCuantity(int cuantity) {
		this.cuantity = cuantity;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	@Override
	public String toString() {
		return "Material [state=" + state + ", materialType=" + materialType + ", cuantity=" + cuantity + ", amount="
				+ amount + ", articleId=" + articleId + "]";
	}
	
}
