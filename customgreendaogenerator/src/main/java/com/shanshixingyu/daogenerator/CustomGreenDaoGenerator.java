package com.shanshixingyu.daogenerator;

import com.shanshixingyu.daogenerator.utils.ReflectUtils;

import java.io.File;
import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class CustomGreenDaoGenerator extends DaoGenerator {
    public CustomGreenDaoGenerator()
        throws IOException {
        super();

        Configuration config = new Configuration();
        File templateDir = new File("mtgreendaogenerator/src/main/res/template");
        if (!templateDir.exists() || !templateDir.isDirectory()) {
            throw new IllegalStateException("模板文件目录不存在");
        }
        config.setDirectoryForTemplateLoading(templateDir);

        Template templateDao = config.getTemplate("dao.ftl");
        Template templateDaoMaster = config.getTemplate("dao-master.ftl");
        Template templateDaoSession = config.getTemplate("dao-session.ftl");
        Template templateEntity = config.getTemplate("entity.ftl");
        Template templateDaoUnitTest = config.getTemplate("dao-unit-test.ftl");
        Template templateContentProvider = config.getTemplate("content-provider.ftl");

        /** 通过反射机制将模板文件实例替换为以上实例 */
        boolean daoSuccess = ReflectUtils.setFieldValue(this, "templateDao", templateDao);
        if (!daoSuccess) {
            throw new IllegalStateException("templateDao实例赋值失败");
        }
        boolean daoMasterSuccess = ReflectUtils.setFieldValue(this, "templateDaoMaster", templateDaoMaster);
        if (!daoMasterSuccess) {
            throw new IllegalStateException("templateDaoMaster实例赋值失败");
        }
        boolean daoSessionSuccess = ReflectUtils.setFieldValue(this, "templateDaoSession", templateDaoSession);
        if (!daoSessionSuccess) {
            throw new IllegalStateException("templateDaoSession实例赋值失败");
        }
        boolean entitySuccess = ReflectUtils.setFieldValue(this, "templateEntity", templateEntity);
        if (!entitySuccess) {
            throw new IllegalStateException("templateEntity实例赋值失败");
        }
        boolean daoUnitTestSuccess = ReflectUtils.setFieldValue(this, "templateDaoUnitTest", templateDaoUnitTest);
        if (!daoUnitTestSuccess) {
            throw new IllegalStateException("templateDaoUnitTest实例赋值失败");
        }
        boolean contentProviderSuccess =
            ReflectUtils.setFieldValue(this, "templateContentProvider", templateContentProvider);
        if (!contentProviderSuccess) {
            throw new IllegalStateException("templateContentProvider实例赋值失败");
        }
    }
}
