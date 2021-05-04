package com.bizpoll.action;

public class ActionFoward {
	private String path;
	
	// true -> sendRedirect, false -> forward
	private boolean isRedirect;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	@Override
	public String toString() {
		return "ActionFoward [path=" + path + ", isRedirect=" + isRedirect + "]";
	}
	
	
}
