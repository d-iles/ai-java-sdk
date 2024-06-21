package d.wwood.ai.sdk.openai.assistant.constant;

/**
 * @description:
 * @author: vacuity
 * @create: 2024-03-20 11:11
 **/

public class AssistantStreamEventsConstant {

    public static final String THREAD_CREATED = "thread.created";

    public static final String THREAD_RUN_CREATED = "thread.run.created";

    public static final String THREAD_RUN_QUEUED = "thread.run.queued";

    public static final String THREAD_RUN_IN_PROGRESS = "thread.run.in_progress";

    public static final String THREAD_RUN_REQUIRES_ACTION = "thread.run.requires_action";

    public static final String THREAD_RUN_COMPLETED = "thread.run.completed";

    public static final String THREAD_RUN_FAILED = "thread.run.failed";

    public static final String THREAD_RUN_CANCELLING = "thread.run.cancelling";

    public static final String THREAD_RUN_CANCELLED = "thread.run.cancelled";

    public static final String THREAD_RUN_EXPIRED = "thread.run.expired";

    public static final String THREAD_RUN_STEP_CREATED = "thread.run.step.created";

    public static final String THREAD_RUN_STEP_IN_PROGRESS = "thread.run.step.in_progress";

    public static final String THREAD_RUN_STEP_DELTA = "thread.run.step.delta";

    public static final String THREAD_RUN_STEP_COMPLETED = "thread.run.step.completed";

    public static final String THREAD_RUN_STEP_FAILED = "thread.run.step.failed";

    public static final String THREAD_RUN_STEP_CANCELLED = "thread.run.step.cancelled";

    public static final String THREAD_RUN_STEP_EXPIRED = "thread.run.step.expired";

    public static final String THREAD_MESSAGE_CREATED = "thread.message.created";

    public static final String THREAD_MESSAGE_IN_PROGRESS = "thread.message.in_progress";

    public static final String THREAD_MESSAGE_DELTA = "thread.message.delta";

    public static final String THREAD_MESSAGE_COMPLETED = "thread.message.completed";

    public static final String THREAD_MESSAGE_INCOMPLETE = "thread.message.incomplete";

    public static final String ERROR = "error";

    public static final String DONE = "done";
}
