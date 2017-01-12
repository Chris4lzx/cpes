package com.atguigu.crowdfunding.cpes.bean;

import java.util.ArrayList;
import java.util.List;

public class Permission {
    private Integer id;

    private String name;

    private String url;

    private String icon;

    private Integer pid;
    
    private Integer seqno;
    
    private boolean open = true;
    
    private boolean checked = false;
    
    private List<Permission> children = new ArrayList<Permission>();
    
    public Permission() {
		super();
	}

	public Permission(Integer id, String name, String url, String icon, Integer pid) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + ", url=" + url + ", icon=" + icon + ", pid=" + pid + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}