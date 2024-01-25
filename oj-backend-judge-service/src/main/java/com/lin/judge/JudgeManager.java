package com.lin.judge;

import com.lin.judge.strategy.DefaultJudgeStrategy;
import com.lin.judge.strategy.JavaLanguageJudgeStrategy;
import com.lin.judge.strategy.JudgeContext;
import com.lin.judge.strategy.JudgeStrategy;
import com.lin.model.codesandbox.JudgeInfo;
import com.lin.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
