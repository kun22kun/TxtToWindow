 /*
  * @author ���
  */
package com.code.txttownd.config;

/**
 * 
 * 	�ֶ������ࣺ��ֵ����ֵ����ֵ����ֵ��Specֵ
 *
 */
public class Configuration {
	
	/**
	 * �ؼ���ֵ
	 */
	private int hang;
	
	/**
	 * �ؼ���ֵ
	 */
	private int lie;
	
	/**
	 * �ؼ���ֵ
	 */
	private int kuan;
	
	/**
	 * �ؼ���ֵ
	 */
	private int gao;
	
	/**
	 * �ؼ�Specֵ
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
