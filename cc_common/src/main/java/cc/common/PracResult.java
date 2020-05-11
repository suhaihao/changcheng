package cc.common;

import java.io.Serializable;

public class PracResult implements Serializable{
	private int code;
	private String msg;
	private Object data;
	private int page;
	private int size;
	private int total;
	
	
	public PracResult() {
		super();
	}
	
	public PracResult(int code, String msg, Object data, int page, int size, int total) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.page = page;
		this.size = size;
		this.total = total;
	}

	public PracResult(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public PracResult(int code, String msg, Object data, int page, int size) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.page = page;
		this.size = size;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + page;
		result = prime * result + size;
		result = prime * result + total;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PracResult other = (PracResult) obj;
		if (code != other.code)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (page != other.page)
			return false;
		if (size != other.size)
			return false;
		if (total != other.total)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PracResult [code=" + code + ", msg=" + msg + ", data=" + data + ", page=" + page + ", size=" + size
				+ ", total=" + total + "]";
	}
	

}
