package mplanweb.music.web.board;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ResultJSON implements Serializable {

	private Object data;
	private List<?> items; // 한페이지에 출력되는 레코드 리스트
	private String msg; // 리턴 메시지
	private Object success;
	private int total;

	/**
	 * 단일 객체 저장 주로 view 용도
	 * 
	 * @param item
	 */
	public final void setData(final Object data) {
		this.data = data;
	}

	/**
	 * 단일 객체 리턴
	 * 
	 * @return
	 */
	public final Object getData() {
		return data;
	}

	/**
	 * 객체 리스트 저장
	 * 
	 * @param items
	 */
	public final void setItems(final List<?> items) {
		this.items = items;
	}

	/**
	 * 객체 리스트 리턴
	 * 
	 * @return
	 */
	public final List<?> getItems() {
		return items;
	}

	/**
	 * 리턴 메시지 세팅 (실패시)
	 * 
	 * @param msg
	 */
	public final void setMsg(final String msg) {
		this.msg = msg;
	}

	/**
	 * 리턴 메시지 리턴
	 * 
	 * @return
	 */
	public final String getMsg() {
		return msg;
	}

	/**
	 * 성공: true, 실패:false 세팅
	 * 
	 * @param success
	 */
	public final void setSuccess(final Object success) {
		this.success = success;
	}

	/**
	 * 성공: true, 실패:false 리턴
	 * 
	 * @param success
	 */
	public final Object getSuccess() {
		return success;
	}

	/**
	 * 총 레코드수 세팅
	 * 
	 * @param total
	 */
	public final void setTotal(final int total) {
		this.total = total;
	}

	/**
	 * 총 레코드 리턴
	 * 
	 * @return
	 */
	public final int getTotal() {
		return total;
	}
}
