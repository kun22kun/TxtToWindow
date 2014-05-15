package com.code.txttownd.config;

/**
 * @author 骞坤</br></br>
 * 
 * 	字段配置类：行值、列值、宽值、高值、Spec值
 *
 */
public class Configuration {
	
	/**
	 * 控件行值
	 */
	private int H;
	
	/**
	 * 控件列值
	 */
	private int L;
	
	/**
	 * 控件宽值
	 */
	private int K;
	
	/**
	 * 控件高值
	 */
	private int G;
	
	/**
	 * 控件Spec值
	 */
	private String spec = null;

	public int getH() {
		return H;
	}

	public void setH(int h) {
		H = h;
	}

	public int getL() {
		return L;
	}

	public void setL(int l) {
		L = l;
	}

	public int getK() {
		return K;
	}

	public void setK(int k) {
		K = k;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	
	

}
