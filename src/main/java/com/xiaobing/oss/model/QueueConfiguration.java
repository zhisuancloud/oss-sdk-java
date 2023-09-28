/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.xiaobing.oss.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.SdkField;
import software.amazon.awssdk.core.SdkPojo;
import software.amazon.awssdk.core.protocol.MarshallLocation;
import software.amazon.awssdk.core.protocol.MarshallingType;
import software.amazon.awssdk.core.traits.ListTrait;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.core.util.DefaultSdkAutoConstructList;
import software.amazon.awssdk.core.util.SdkAutoConstructList;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Specifies the configuration for publishing messages to an Amazon Simple Queue Service (Amazon SQS) queue when Amazon
 * S3 detects specified events.
 * </p>
 */
@Generated("software.amazon.awssdk:codegen")
public final class QueueConfiguration implements SdkPojo, Serializable,
        ToCopyableBuilder<QueueConfiguration.Builder, QueueConfiguration> {
    private static final SdkField<String> ID_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("Id")
            .getter(getter(QueueConfiguration::id))
            .setter(setter(Builder::id))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Id").unmarshallLocationName("Id")
                    .build()).build();

    private static final SdkField<String> QUEUE_ARN_FIELD = SdkField
            .<String> builder(MarshallingType.STRING)
            .memberName("QueueArn")
            .getter(getter(QueueConfiguration::queueArn))
            .setter(setter(Builder::queueArn))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Queue")
                    .unmarshallLocationName("Queue").build()).build();

    private static final SdkField<List<String>> EVENTS_FIELD = SdkField
            .<List<String>> builder(MarshallingType.LIST)
            .memberName("Events")
            .getter(getter(QueueConfiguration::eventsAsStrings))
            .setter(setter(Builder::eventsWithStrings))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Event")
                    .unmarshallLocationName("Event").build(),
                    ListTrait
                            .builder()
                            .memberLocationName(null)
                            .memberFieldInfo(
                                    SdkField.<String> builder(MarshallingType.STRING)
                                            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD)
                                                    .locationName("member").unmarshallLocationName("member").build()).build())
                            .isFlattened(true).build()).build();

    private static final SdkField<NotificationConfigurationFilter> FILTER_FIELD = SdkField
            .<NotificationConfigurationFilter> builder(MarshallingType.SDK_POJO)
            .memberName("Filter")
            .getter(getter(QueueConfiguration::filter))
            .setter(setter(Builder::filter))
            .constructor(NotificationConfigurationFilter::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("Filter")
                    .unmarshallLocationName("Filter").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(ID_FIELD, QUEUE_ARN_FIELD,
            EVENTS_FIELD, FILTER_FIELD));

    private static final long serialVersionUID = 1L;

    private final String id;

    private final String queueArn;

    private final List<String> events;

    private final NotificationConfigurationFilter filter;

    private QueueConfiguration(BuilderImpl builder) {
        this.id = builder.id;
        this.queueArn = builder.queueArn;
        this.events = builder.events;
        this.filter = builder.filter;
    }

    /**
     * Returns the value of the Id property for this object.
     * 
     * @return The value of the Id property for this object.
     */
    public final String id() {
        return id;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) of the Amazon SQS queue to which Amazon S3 publishes a message when it detects
     * events of the specified type.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) of the Amazon SQS queue to which Amazon S3 publishes a message when it
     *         detects events of the specified type.
     */
    public final String queueArn() {
        return queueArn;
    }

    /**
     * <p>
     * A collection of bucket events for which to send notifications
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEvents} method.
     * </p>
     * 
     * @return A collection of bucket events for which to send notifications
     */
    public final List<Event> events() {
        return EventListCopier.copyStringToEnum(events);
    }

    /**
     * For responses, this returns true if the service returned a value for the Events property. This DOES NOT check
     * that the value is non-empty (for which, you should check the {@code isEmpty()} method on the property). This is
     * useful because the SDK will never return a null collection or map, but you may need to differentiate between the
     * service returning nothing (or null) and the service returning an empty collection or map. For requests, this
     * returns true if a value for the property was specified in the request builder, and false if a value was not
     * specified.
     */
    public final boolean hasEvents() {
        return events != null && !(events instanceof SdkAutoConstructList);
    }

    /**
     * <p>
     * A collection of bucket events for which to send notifications
     * </p>
     * <p>
     * Attempts to modify the collection returned by this method will result in an UnsupportedOperationException.
     * </p>
     * <p>
     * This method will never return null. If you would like to know whether the service returned this field (so that
     * you can differentiate between null and empty), you can use the {@link #hasEvents} method.
     * </p>
     * 
     * @return A collection of bucket events for which to send notifications
     */
    public final List<String> eventsAsStrings() {
        return events;
    }

    /**
     * Returns the value of the Filter property for this object.
     * 
     * @return The value of the Filter property for this object.
     */
    public final NotificationConfigurationFilter filter() {
        return filter;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + Objects.hashCode(id());
        hashCode = 31 * hashCode + Objects.hashCode(queueArn());
        hashCode = 31 * hashCode + Objects.hashCode(hasEvents() ? eventsAsStrings() : null);
        hashCode = 31 * hashCode + Objects.hashCode(filter());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof QueueConfiguration)) {
            return false;
        }
        QueueConfiguration other = (QueueConfiguration) obj;
        return Objects.equals(id(), other.id()) && Objects.equals(queueArn(), other.queueArn())
                && hasEvents() == other.hasEvents() && Objects.equals(eventsAsStrings(), other.eventsAsStrings())
                && Objects.equals(filter(), other.filter());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("QueueConfiguration").add("Id", id()).add("QueueArn", queueArn())
                .add("Events", hasEvents() ? eventsAsStrings() : null).add("Filter", filter()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "Id":
            return Optional.ofNullable(clazz.cast(id()));
        case "QueueArn":
            return Optional.ofNullable(clazz.cast(queueArn()));
        case "Events":
            return Optional.ofNullable(clazz.cast(eventsAsStrings()));
        case "Filter":
            return Optional.ofNullable(clazz.cast(filter()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<QueueConfiguration, T> g) {
        return obj -> g.apply((QueueConfiguration) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, QueueConfiguration> {
        /**
         * Sets the value of the Id property for this object.
         *
         * @param id
         *        The new value for the Id property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder id(String id);

        /**
         * <p>
         * The Amazon Resource Name (ARN) of the Amazon SQS queue to which Amazon S3 publishes a message when it detects
         * events of the specified type.
         * </p>
         * 
         * @param queueArn
         *        The Amazon Resource Name (ARN) of the Amazon SQS queue to which Amazon S3 publishes a message when it
         *        detects events of the specified type.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder queueArn(String queueArn);

        /**
         * <p>
         * A collection of bucket events for which to send notifications
         * </p>
         * 
         * @param events
         *        A collection of bucket events for which to send notifications
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder eventsWithStrings(Collection<String> events);

        /**
         * <p>
         * A collection of bucket events for which to send notifications
         * </p>
         * 
         * @param events
         *        A collection of bucket events for which to send notifications
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder eventsWithStrings(String... events);

        /**
         * <p>
         * A collection of bucket events for which to send notifications
         * </p>
         * 
         * @param events
         *        A collection of bucket events for which to send notifications
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder events(Collection<Event> events);

        /**
         * <p>
         * A collection of bucket events for which to send notifications
         * </p>
         * 
         * @param events
         *        A collection of bucket events for which to send notifications
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder events(Event... events);

        /**
         * Sets the value of the Filter property for this object.
         *
         * @param filter
         *        The new value for the Filter property for this object.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder filter(NotificationConfigurationFilter filter);

        /**
         * Sets the value of the Filter property for this object.
         *
         * This is a convenience method that creates an instance of the {@link NotificationConfigurationFilter.Builder}
         * avoiding the need to create one manually via {@link NotificationConfigurationFilter#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link NotificationConfigurationFilter.Builder#build()} is called
         * immediately and its result is passed to {@link #filter(NotificationConfigurationFilter)}.
         * 
         * @param filter
         *        a consumer that will call methods on {@link NotificationConfigurationFilter.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #filter(NotificationConfigurationFilter)
         */
        default Builder filter(Consumer<NotificationConfigurationFilter.Builder> filter) {
            return filter(NotificationConfigurationFilter.builder().applyMutation(filter).build());
        }
    }

    static final class BuilderImpl implements Builder {
        private String id;

        private String queueArn;

        private List<String> events = DefaultSdkAutoConstructList.getInstance();

        private NotificationConfigurationFilter filter;

        private BuilderImpl() {
        }

        private BuilderImpl(QueueConfiguration model) {
            id(model.id);
            queueArn(model.queueArn);
            eventsWithStrings(model.events);
            filter(model.filter);
        }

        public final String getId() {
            return id;
        }

        public final void setId(String id) {
            this.id = id;
        }

        @Override
        public final Builder id(String id) {
            this.id = id;
            return this;
        }

        public final String getQueueArn() {
            return queueArn;
        }

        public final void setQueueArn(String queueArn) {
            this.queueArn = queueArn;
        }

        @Override
        public final Builder queueArn(String queueArn) {
            this.queueArn = queueArn;
            return this;
        }

        public final Collection<String> getEvents() {
            if (events instanceof SdkAutoConstructList) {
                return null;
            }
            return events;
        }

        public final void setEvents(Collection<String> events) {
            this.events = EventListCopier.copy(events);
        }

        @Override
        public final Builder eventsWithStrings(Collection<String> events) {
            this.events = EventListCopier.copy(events);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder eventsWithStrings(String... events) {
            eventsWithStrings(Arrays.asList(events));
            return this;
        }

        @Override
        public final Builder events(Collection<Event> events) {
            this.events = EventListCopier.copyEnumToString(events);
            return this;
        }

        @Override
        @SafeVarargs
        public final Builder events(Event... events) {
            events(Arrays.asList(events));
            return this;
        }

        public final NotificationConfigurationFilter.Builder getFilter() {
            return filter != null ? filter.toBuilder() : null;
        }

        public final void setFilter(NotificationConfigurationFilter.BuilderImpl filter) {
            this.filter = filter != null ? filter.build() : null;
        }

        @Override
        public final Builder filter(NotificationConfigurationFilter filter) {
            this.filter = filter;
            return this;
        }

        @Override
        public QueueConfiguration build() {
            return new QueueConfiguration(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
