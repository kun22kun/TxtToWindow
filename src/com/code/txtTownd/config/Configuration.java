 /*
  * @author 骞坤
  */
package com.code.txttownd.config;

/**
 * 
 * 	字段配置类：行值、列值、宽值、高值、Spec值
 *
 */
public class Configuration {
	
	/**
	 * 控件行值
	 */
	private int hang;
	
	/**
	 * 控件列值
	 */
	private int lie;
	
	/**
	 * 控件宽值
	 */
	private int kuan;
	
	/**
	 * 控件高值
	 */
	private int gao;
	
	/**
	 * 控件Spec值
	 */
	private String spec = null;

	public int getH() {
		return hang;
	}

	public void setH(int h) {
		hang = h;
	}

	public int getL() {
		return lie;
	}

	public void setL(int l) {
		lie = l;
	}

	public int getK() {
		return kuan;
	}

	public void setK(int k) {
		kuan = k;
	}

	public int getG() {
		return gao;
	}

	public void setG(int g) {
		gao = g;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}	

}
