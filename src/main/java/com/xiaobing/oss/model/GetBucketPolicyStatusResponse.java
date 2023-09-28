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

import java.util.Arrays;
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
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.core.traits.PayloadTrait;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 */
@Generated("software.amazon.awssdk:codegen")
public final class GetBucketPolicyStatusResponse extends S3Response implements
        ToCopyableBuilder<GetBucketPolicyStatusResponse.Builder, GetBucketPolicyStatusResponse> {
    private static final SdkField<PolicyStatus> POLICY_STATUS_FIELD = SdkField
            .<PolicyStatus> builder(MarshallingType.SDK_POJO)
            .memberName("PolicyStatus")
            .getter(getter(GetBucketPolicyStatusResponse::policyStatus))
            .setter(setter(Builder::policyStatus))
            .constructor(PolicyStatus::builder)
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("PolicyStatus")
                    .unmarshallLocationName("PolicyStatus").build(), PayloadTrait.create()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(POLICY_STATUS_FIELD));

    private final PolicyStatus policyStatus;

    private GetBucketPolicyStatusResponse(BuilderImpl builder) {
        super(builder);
        this.policyStatus = builder.policyStatus;
    }

    /**
     * <p>
     * The policy status for the specified bucket.
     * </p>
     * 
     * @return The policy status for the specified bucket.
     */
    public final PolicyStatus policyStatus() {
        return policyStatus;
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
        hashCode = 31 * hashCode + super.hashCode();
        hashCode = 31 * hashCode + Objects.hashCode(policyStatus());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return super.equals(obj) && equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GetBucketPolicyStatusResponse)) {
            return false;
        }
        GetBucketPolicyStatusResponse other = (GetBucketPolicyStatusResponse) obj;
        return Objects.equals(policyStatus(), other.policyStatus());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("GetBucketPolicyStatusResponse").add("PolicyStatus", policyStatus()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "PolicyStatus":
            return Optional.ofNullable(clazz.cast(policyStatus()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<GetBucketPolicyStatusResponse, T> g) {
        return obj -> g.apply((GetBucketPolicyStatusResponse) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends S3Response.Builder, SdkPojo, CopyableBuilder<Builder, GetBucketPolicyStatusResponse> {
        /**
         * <p>
         * The policy status for the specified bucket.
         * </p>
         * 
         * @param policyStatus
         *        The policy status for the specified bucket.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder policyStatus(PolicyStatus policyStatus);

        /**
         * <p>
         * The policy status for the specified bucket.
         * </p>
         * This is a convenience method that creates an instance of the {@link PolicyStatus.Builder} avoiding the need
         * to create one manually via {@link PolicyStatus#builder()}.
         *
         * <p>
         * When the {@link Consumer} completes, {@link PolicyStatus.Builder#build()} is called immediately and its
         * result is passed to {@link #policyStatus(PolicyStatus)}.
         * 
         * @param policyStatus
         *        a consumer that will call methods on {@link PolicyStatus.Builder}
         * @return Returns a reference to this object so that method calls can be chained together.
         * @see #policyStatus(PolicyStatus)
         */
        default Builder policyStatus(Consumer<PolicyStatus.Builder> policyStatus) {
            return policyStatus(PolicyStatus.builder().applyMutation(policyStatus).build());
        }
    }

    static final class BuilderImpl extends S3Response.BuilderImpl implements Builder {
        private PolicyStatus policyStatus;

        private BuilderImpl() {
        }

        private BuilderImpl(GetBucketPolicyStatusResponse model) {
            super(model);
            policyStatus(model.policyStatus);
        }

        public final PolicyStatus.Builder getPolicyStatus() {
            return policyStatus != null ? policyStatus.toBuilder() : null;
        }

        public final void setPolicyStatus(PolicyStatus.BuilderImpl policyStatus) {
            this.policyStatus = policyStatus != null ? policyStatus.build() : null;
        }

        @Override
        public final Builder policyStatus(PolicyStatus policyStatus) {
            this.policyStatus = policyStatus;
            return this;
        }

        @Override
        public GetBucketPolicyStatusResponse build() {
            return new GetBucketPolicyStatusResponse(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
