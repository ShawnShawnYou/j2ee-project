package entity;

import java.util.Date;

public class Applicant {

	private String zhanghao; //账号
	private String mima; //密码
	private String Firstname;//名
	private String Lastname;//姓
	private String addr;//地址
	private String pageNo;//页面编码
	private int id;//id编号
	private int td_id;//订单id
	public int getTd_id() {
		return td_id;
	}

	public void setTd_id(int td_id) {
		this.td_id = td_id;
	}

	private String goods_name;//商品名
	private String goods_number;//货物数量
	private String goods_baozhuang ;//货物包装
	private String goods_weight ;//货物重量
	private String goods_volume ;//货物体积
	private String fahuo_person ;//发货人
	private String	shouhuo_person ;//收货人
	private Date fahuo_date ;//发货日期
	private String	fahuo_addr ;//发货地
	private String shouhuo_addr ;//目的地
	private String tuoyun_money  ;//托运费
	private String shonghuo_money  ;//送货费
	private String	baoxian_money  ;//保险费
	private String	jiehuo_money  ;//接货费
	private String	pay_money ;//支付方式
	private String	pick ;//取货方式
	private String	single; //制单
	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_number() {
		return goods_number;
	}

	public void setGoods_number(String goods_number) {
		this.goods_number = goods_number;
	}

	public String getGoods_baozhuang() {
		return goods_baozhuang;
	}

	public void setGoods_baozhuang(String goods_baozhuang) {
		this.goods_baozhuang = goods_baozhuang;
	}

	public String getGoods_weight() {
		return goods_weight;
	}

	public void setGoods_weight(String goods_weight) {
		this.goods_weight = goods_weight;
	}

	public String getGoods_volume() {
		return goods_volume;
	}

	public void setGoods_volume(String goods_volume) {
		this.goods_volume = goods_volume;
	}

	public String getFahuo_person() {
		return fahuo_person;
	}

	public void setFahuo_person(String fahuo_person) {
		this.fahuo_person = fahuo_person;
	}

	public String getShouhuo_person() {
		return shouhuo_person;
	}

	public void setShouhuo_person(String shouhuo_person) {
		this.shouhuo_person = shouhuo_person;
	}

	public Date getFahuo_date() {
		return fahuo_date;
	}

	public void setFahuo_date(Date fahuo_date) {
		this.fahuo_date = fahuo_date;
	}

	public String getFahuo_addr() {
		return fahuo_addr;
	}

	public void setFahuo_addr(String fahuo_addr) {
		this.fahuo_addr = fahuo_addr;
	}

	public String getShouhuo_addr() {
		return shouhuo_addr;
	}

	public void setShouhuo_addr(String shouhuo_addr) {
		this.shouhuo_addr = shouhuo_addr;
	}

	public String getTuoyun_money() {
		return tuoyun_money;
	}

	public void setTuoyun_money(String tuoyun_money) {
		this.tuoyun_money = tuoyun_money;
	}

	public String getShonghuo_money() {
		return shonghuo_money;
	}

	public void setShonghuo_money(String shonghuo_money) {
		this.shonghuo_money = shonghuo_money;
	}

	public String getBaoxian_money() {
		return baoxian_money;
	}

	public void setBaoxian_money(String baoxian_money) {
		this.baoxian_money = baoxian_money;
	}

	public String getJiehuo_money() {
		return jiehuo_money;
	}

	public void setJiehuo_money(String jiehuo_money) {
		this.jiehuo_money = jiehuo_money;
	}

	public String getPay_money() {
		return pay_money;
	}

	public void setPay_money(String pay_money) {
		this.pay_money = pay_money;
	}

	public String getPick() {
		return pick;
	}

	public void setPick(String pick) {
		this.pick = pick;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}


	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

}
