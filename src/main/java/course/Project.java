package course;

public class Project {
    int id;
    String ModuleName;
    String ProjectDocPath;
    String Description;

    public Project() {}

    public Project(String ModuleName, String ProjectDocPath, String Description) {
        this.ModuleName = ModuleName;
        this.ProjectDocPath = ProjectDocPath;
        this.Description = Description;
    }

    public Project(int id, String ModuleName, String ProjectDoc, String Description) {
        this.id = id;
        this.ModuleName = ModuleName;
        this.ProjectDocPath = ProjectDoc;
        this.Description = Description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModuleName() {
        return ModuleName;
    }
    public void setModuleName(String ModuleName) {
        this.ModuleName = ModuleName;
    }
    public String getProjectDocPath() {
        return ProjectDocPath;
    }
    public void setProjectDoc(String ProjectDoc) {
        this.ProjectDocPath = ProjectDoc;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
}
