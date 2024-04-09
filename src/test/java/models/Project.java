package models;

import java.util.Objects;

public class Project {
    private int id;
    private String name;
    private  String announcement;
    private boolean isShowAnnouncement;
    private int projectType;
    private boolean isEnableTCApproval;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean isShowAnnouncement() {
        return isShowAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        isShowAnnouncement = showAnnouncement;
    }

    public int getProjectType() {
        return projectType;
    }

    public void setProjectType(int projectType) {
        this.projectType = projectType;
    }

    public boolean isEnableTCApproval() {
        return isEnableTCApproval;
    }

    public void setEnableTCApproval(boolean enableTCApproval) {
        isEnableTCApproval = enableTCApproval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return isShowAnnouncement == project.isShowAnnouncement && projectType == project.projectType && isEnableTCApproval == project.isEnableTCApproval && Objects.equals(name, project.name) && Objects.equals(announcement, project.announcement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, announcement, isShowAnnouncement, projectType, isEnableTCApproval);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", isShowAnnouncement=" + isShowAnnouncement +
                ", projectType=" + projectType +
                ", isEnableTCApproval=" + isEnableTCApproval +
                '}';
    }
}