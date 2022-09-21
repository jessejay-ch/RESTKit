package io.github.newhoo.restkit.parameter.library;//package io.github.newhoo.restkit.parameter.library;
//
//import com.intellij.openapi.actionSystem.AnAction;
//import com.intellij.openapi.actionSystem.CustomShortcutSet;
//import com.intellij.openapi.actionSystem.DefaultActionGroup;
//import com.intellij.openapi.actionSystem.KeyboardShortcut;
//import com.intellij.openapi.actionSystem.Separator;
//import com.intellij.openapi.editor.Editor;
//import com.intellij.openapi.editor.impl.EditorImpl;
//import com.intellij.openapi.editor.markup.InspectionWidgetActionProvider;
//import com.intellij.openapi.project.Project;
//import com.intellij.openapi.util.SystemInfo;
//import io.github.newhoo.restkit.config.CommonSetting;
//import io.github.newhoo.restkit.config.CommonSettingComponent;
//import io.github.newhoo.restkit.config.ParameterLibrary;
//import org.apache.commons.lang3.StringUtils;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import javax.swing.*;
//
///**
// * 利用监视动作提供参数库操作
// *
// * @author huzunrong
// * @since 1.0.8
// */
//public class ParameterLibraryActionProvider implements InspectionWidgetActionProvider {
//
//    private final KeyboardShortcut saveParameterShortcut = KeyboardShortcut.fromString(SystemInfo.isMac ? "meta S" : "control S");
//    private final KeyboardShortcut showParameterShortcut = KeyboardShortcut.fromString(SystemInfo.isMac ? "meta shift S" : "control shift S");
//
//    @Nullable
//    @Override
//    public AnAction createAction(@NotNull Editor editor) {
//        Project project = editor.getProject();
//        if (project == null || project.isDefault()) {
//            return null;
//        }
//        CommonSetting setting = CommonSettingComponent.getInstance(project).getState();
//        if (!setting.isEnableParameterLibrary()) {
//            return null;
//        }
//        String editorDoc = editor.getDocument().toString().replace("\\", "/");
//        if (StringUtils.containsAny(editorDoc, "/Headers", "/Params", "/Body")) {
//            ParameterLibrary parameterLibrary = ParameterLibrary.getInstance(project);
//            AnAction saveParameterAction = new SaveParameterAction(editor, parameterLibrary);
//            AnAction showParameterAction = new ShowParameterAction(editor, parameterLibrary);
//            DefaultActionGroup defaultActionGroup = new DefaultActionGroup(saveParameterAction, showParameterAction);
//
//            if (setting.isEnableParameterLibraryShortcut() && editor instanceof EditorImpl) {
//                JComponent editorComponent = ((EditorImpl) editor).getScrollPane();
//                saveParameterAction.registerCustomShortcutSet(new CustomShortcutSet(saveParameterShortcut), editorComponent);
//                showParameterAction.registerCustomShortcutSet(new CustomShortcutSet(showParameterShortcut), editorComponent);
//            }
//            if (StringUtils.contains(editorDoc, "/Body")) {
//                defaultActionGroup.add(Separator.create());
//            }
//            return defaultActionGroup;
//        }
//        return null;
//    }
//}