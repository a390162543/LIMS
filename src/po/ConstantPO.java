package po;

import java.io.Serializable;

import vo.ConstantVO;

/**
 * {@code ConstantPO}�Ǽ۸�ҵ���߼��������ݲ�֮�䴫�ݵĳ־û�����
 * ��¼�˼۸��������Ϣ
 * @author ������
 */
public class ConstantPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2490864291437683436L;
	private double price;
	 
	
	 
	
	public ConstantPO(double price) {
		super();
		this.price = price;
	}

	public ConstantVO getConstantVO(){
		return new ConstantVO(price);
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	 
}
