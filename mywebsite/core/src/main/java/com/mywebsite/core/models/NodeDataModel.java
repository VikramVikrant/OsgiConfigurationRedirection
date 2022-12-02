package com.mywebsite.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.inject.Inject;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NodeDataModel {
    @SlingObject
    ResourceResolver resourceResolver;
    @Inject
    private String name;

    public String getName() {
        return resourceResolver.getResource("/content/dataNode1").getName();
    }
    @Inject
    private String path;

    public String getPath() {
        return resourceResolver.getResource("/content/dataNode1").getPath();
    }
//    @Inject
//    public Iterator<Resource> Children;
//
//    public Iterator<Resource> getChildren() {
//        return resourceResolver.getResource("/content/dataNode1").listChildren();
//    }
    @Inject
    private String NodeName;

    public Resource getNodeName() {
        return resourceResolver.getResource("/content/dataNode1");
    }
    @Inject
    String title;

    public String getTitle() {
        return resourceResolver.getResource("/content/dataNode1").getValueMap().get("name",String.class);
    }
    @Inject
    private String dob;

    public String getDob() {
        return resourceResolver.getResource("/content/dataNode1").getValueMap().get("dob",String.class);
    }
    @Inject
    private String age;
    @Inject
    private String phoneNo;

    public String getAge() {
        return resourceResolver.getResource("/content/dataNode1").getValueMap().get("age",String.class);
    }

    public String getPhoneNo() {
        return resourceResolver.getResource("/content/dataNode1").getValueMap().get("phoneNo",String.class);
    }
    //    private ValueMap componentPropertymap;
//    private List<String> propertylist;
//    private String namepropertyvalue;
//
//    @PostConstruct
//    protected void init() {
//        Resource childresource= resourceResolver.getResource("/content/dataNode1");
//        for (Iterator<Resource> it = childresource.listChildren(); it.hasNext(); ) {
//            Resource resource = it.next();
//            componentPropertymap = resource.getValueMap();
//            namepropertyvalue = componentPropertymap.get("name", String.class);
//            propertylist.add(namepropertyvalue);
//
//        }
//    }

//    public List<String> getPropertylist() {
//        return propertylist;
//    }

//    public Iterator<Resource> getAllChildren() {
//        return resourceResolver.getResource("/content/dataNode1").listChildren();
//    }


}
