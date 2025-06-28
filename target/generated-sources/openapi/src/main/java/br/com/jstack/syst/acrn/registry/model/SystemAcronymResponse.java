package br.com.jstack.syst.acrn.registry.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SystemAcronymResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-27T21:24:08.809116-03:00[America/Sao_Paulo]", comments = "Generator version: 7.14.0")
public class SystemAcronymResponse {

  private String acronym;

  private String name;

  private @Nullable String description;

  private Integer domainId;

  private Integer typeId;

  private @Nullable Integer ownerUserId;

  private @Nullable Integer devTeamId;

  private @Nullable Integer bizTeamId;

  private @Nullable String productOwnerName;

  private @Nullable String contactEmail;

  private @Nullable Boolean criticalForOperation;

  private @Nullable Boolean hasPersonalData;

  private @Nullable String securityLevel;

  private @Nullable String complianceRequirements;

  private @Nullable String documentationUrl;

  private @Nullable String lifecycleStatus;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate goLiveDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate sunsetDate;

  private @Nullable Boolean active;

  private @Nullable String createdBy;

  private @Nullable Integer id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  private @Nullable String updatedBy;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime updatedAt;

  public SystemAcronymResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SystemAcronymResponse(String acronym, String name, Integer domainId, Integer typeId) {
    this.acronym = acronym;
    this.name = name;
    this.domainId = domainId;
    this.typeId = typeId;
  }

  public SystemAcronymResponse acronym(String acronym) {
    this.acronym = acronym;
    return this;
  }

  /**
   * Get acronym
   * @return acronym
   */
  @NotNull 
  @Schema(name = "acronym", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("acronym")
  public String getAcronym() {
    return acronym;
  }

  public void setAcronym(String acronym) {
    this.acronym = acronym;
  }

  public SystemAcronymResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SystemAcronymResponse description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public SystemAcronymResponse domainId(Integer domainId) {
    this.domainId = domainId;
    return this;
  }

  /**
   * Get domainId
   * @return domainId
   */
  @NotNull 
  @Schema(name = "domain_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("domain_id")
  public Integer getDomainId() {
    return domainId;
  }

  public void setDomainId(Integer domainId) {
    this.domainId = domainId;
  }

  public SystemAcronymResponse typeId(Integer typeId) {
    this.typeId = typeId;
    return this;
  }

  /**
   * Get typeId
   * @return typeId
   */
  @NotNull 
  @Schema(name = "type_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type_id")
  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  public SystemAcronymResponse ownerUserId(@Nullable Integer ownerUserId) {
    this.ownerUserId = ownerUserId;
    return this;
  }

  /**
   * Get ownerUserId
   * @return ownerUserId
   */
  
  @Schema(name = "owner_user_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("owner_user_id")
  public @Nullable Integer getOwnerUserId() {
    return ownerUserId;
  }

  public void setOwnerUserId(@Nullable Integer ownerUserId) {
    this.ownerUserId = ownerUserId;
  }

  public SystemAcronymResponse devTeamId(@Nullable Integer devTeamId) {
    this.devTeamId = devTeamId;
    return this;
  }

  /**
   * Get devTeamId
   * @return devTeamId
   */
  
  @Schema(name = "dev_team_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dev_team_id")
  public @Nullable Integer getDevTeamId() {
    return devTeamId;
  }

  public void setDevTeamId(@Nullable Integer devTeamId) {
    this.devTeamId = devTeamId;
  }

  public SystemAcronymResponse bizTeamId(@Nullable Integer bizTeamId) {
    this.bizTeamId = bizTeamId;
    return this;
  }

  /**
   * Get bizTeamId
   * @return bizTeamId
   */
  
  @Schema(name = "biz_team_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("biz_team_id")
  public @Nullable Integer getBizTeamId() {
    return bizTeamId;
  }

  public void setBizTeamId(@Nullable Integer bizTeamId) {
    this.bizTeamId = bizTeamId;
  }

  public SystemAcronymResponse productOwnerName(@Nullable String productOwnerName) {
    this.productOwnerName = productOwnerName;
    return this;
  }

  /**
   * Get productOwnerName
   * @return productOwnerName
   */
  
  @Schema(name = "product_owner_name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("product_owner_name")
  public @Nullable String getProductOwnerName() {
    return productOwnerName;
  }

  public void setProductOwnerName(@Nullable String productOwnerName) {
    this.productOwnerName = productOwnerName;
  }

  public SystemAcronymResponse contactEmail(@Nullable String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

  /**
   * Get contactEmail
   * @return contactEmail
   */
  
  @Schema(name = "contact_email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contact_email")
  public @Nullable String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(@Nullable String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public SystemAcronymResponse criticalForOperation(@Nullable Boolean criticalForOperation) {
    this.criticalForOperation = criticalForOperation;
    return this;
  }

  /**
   * Get criticalForOperation
   * @return criticalForOperation
   */
  
  @Schema(name = "critical_for_operation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("critical_for_operation")
  public @Nullable Boolean getCriticalForOperation() {
    return criticalForOperation;
  }

  public void setCriticalForOperation(@Nullable Boolean criticalForOperation) {
    this.criticalForOperation = criticalForOperation;
  }

  public SystemAcronymResponse hasPersonalData(@Nullable Boolean hasPersonalData) {
    this.hasPersonalData = hasPersonalData;
    return this;
  }

  /**
   * Get hasPersonalData
   * @return hasPersonalData
   */
  
  @Schema(name = "has_personal_data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("has_personal_data")
  public @Nullable Boolean getHasPersonalData() {
    return hasPersonalData;
  }

  public void setHasPersonalData(@Nullable Boolean hasPersonalData) {
    this.hasPersonalData = hasPersonalData;
  }

  public SystemAcronymResponse securityLevel(@Nullable String securityLevel) {
    this.securityLevel = securityLevel;
    return this;
  }

  /**
   * Get securityLevel
   * @return securityLevel
   */
  
  @Schema(name = "security_level", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("security_level")
  public @Nullable String getSecurityLevel() {
    return securityLevel;
  }

  public void setSecurityLevel(@Nullable String securityLevel) {
    this.securityLevel = securityLevel;
  }

  public SystemAcronymResponse complianceRequirements(@Nullable String complianceRequirements) {
    this.complianceRequirements = complianceRequirements;
    return this;
  }

  /**
   * Get complianceRequirements
   * @return complianceRequirements
   */
  
  @Schema(name = "compliance_requirements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("compliance_requirements")
  public @Nullable String getComplianceRequirements() {
    return complianceRequirements;
  }

  public void setComplianceRequirements(@Nullable String complianceRequirements) {
    this.complianceRequirements = complianceRequirements;
  }

  public SystemAcronymResponse documentationUrl(@Nullable String documentationUrl) {
    this.documentationUrl = documentationUrl;
    return this;
  }

  /**
   * Get documentationUrl
   * @return documentationUrl
   */
  
  @Schema(name = "documentation_url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("documentation_url")
  public @Nullable String getDocumentationUrl() {
    return documentationUrl;
  }

  public void setDocumentationUrl(@Nullable String documentationUrl) {
    this.documentationUrl = documentationUrl;
  }

  public SystemAcronymResponse lifecycleStatus(@Nullable String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

  /**
   * Get lifecycleStatus
   * @return lifecycleStatus
   */
  
  @Schema(name = "lifecycle_status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lifecycle_status")
  public @Nullable String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(@Nullable String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public SystemAcronymResponse goLiveDate(@Nullable LocalDate goLiveDate) {
    this.goLiveDate = goLiveDate;
    return this;
  }

  /**
   * Get goLiveDate
   * @return goLiveDate
   */
  @Valid 
  @Schema(name = "go_live_date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("go_live_date")
  public @Nullable LocalDate getGoLiveDate() {
    return goLiveDate;
  }

  public void setGoLiveDate(@Nullable LocalDate goLiveDate) {
    this.goLiveDate = goLiveDate;
  }

  public SystemAcronymResponse sunsetDate(@Nullable LocalDate sunsetDate) {
    this.sunsetDate = sunsetDate;
    return this;
  }

  /**
   * Get sunsetDate
   * @return sunsetDate
   */
  @Valid 
  @Schema(name = "sunset_date", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sunset_date")
  public @Nullable LocalDate getSunsetDate() {
    return sunsetDate;
  }

  public void setSunsetDate(@Nullable LocalDate sunsetDate) {
    this.sunsetDate = sunsetDate;
  }

  public SystemAcronymResponse active(@Nullable Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
   */
  
  @Schema(name = "active", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("active")
  public @Nullable Boolean getActive() {
    return active;
  }

  public void setActive(@Nullable Boolean active) {
    this.active = active;
  }

  public SystemAcronymResponse createdBy(@Nullable String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Get createdBy
   * @return createdBy
   */
  
  @Schema(name = "created_by", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_by")
  public @Nullable String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(@Nullable String createdBy) {
    this.createdBy = createdBy;
  }

  public SystemAcronymResponse id(@Nullable Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Integer getId() {
    return id;
  }

  public void setId(@Nullable Integer id) {
    this.id = id;
  }

  public SystemAcronymResponse createdAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   */
  @Valid 
  @Schema(name = "created_at", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public @Nullable OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public SystemAcronymResponse updatedBy(@Nullable String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

  /**
   * Get updatedBy
   * @return updatedBy
   */
  
  @Schema(name = "updated_by", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updated_by")
  public @Nullable String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(@Nullable String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public SystemAcronymResponse updatedAt(@Nullable OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updated_at", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updated_at")
  public @Nullable OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(@Nullable OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemAcronymResponse systemAcronymResponse = (SystemAcronymResponse) o;
    return Objects.equals(this.acronym, systemAcronymResponse.acronym) &&
        Objects.equals(this.name, systemAcronymResponse.name) &&
        Objects.equals(this.description, systemAcronymResponse.description) &&
        Objects.equals(this.domainId, systemAcronymResponse.domainId) &&
        Objects.equals(this.typeId, systemAcronymResponse.typeId) &&
        Objects.equals(this.ownerUserId, systemAcronymResponse.ownerUserId) &&
        Objects.equals(this.devTeamId, systemAcronymResponse.devTeamId) &&
        Objects.equals(this.bizTeamId, systemAcronymResponse.bizTeamId) &&
        Objects.equals(this.productOwnerName, systemAcronymResponse.productOwnerName) &&
        Objects.equals(this.contactEmail, systemAcronymResponse.contactEmail) &&
        Objects.equals(this.criticalForOperation, systemAcronymResponse.criticalForOperation) &&
        Objects.equals(this.hasPersonalData, systemAcronymResponse.hasPersonalData) &&
        Objects.equals(this.securityLevel, systemAcronymResponse.securityLevel) &&
        Objects.equals(this.complianceRequirements, systemAcronymResponse.complianceRequirements) &&
        Objects.equals(this.documentationUrl, systemAcronymResponse.documentationUrl) &&
        Objects.equals(this.lifecycleStatus, systemAcronymResponse.lifecycleStatus) &&
        Objects.equals(this.goLiveDate, systemAcronymResponse.goLiveDate) &&
        Objects.equals(this.sunsetDate, systemAcronymResponse.sunsetDate) &&
        Objects.equals(this.active, systemAcronymResponse.active) &&
        Objects.equals(this.createdBy, systemAcronymResponse.createdBy) &&
        Objects.equals(this.id, systemAcronymResponse.id) &&
        Objects.equals(this.createdAt, systemAcronymResponse.createdAt) &&
        Objects.equals(this.updatedBy, systemAcronymResponse.updatedBy) &&
        Objects.equals(this.updatedAt, systemAcronymResponse.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acronym, name, description, domainId, typeId, ownerUserId, devTeamId, bizTeamId, productOwnerName, contactEmail, criticalForOperation, hasPersonalData, securityLevel, complianceRequirements, documentationUrl, lifecycleStatus, goLiveDate, sunsetDate, active, createdBy, id, createdAt, updatedBy, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemAcronymResponse {\n");
    sb.append("    acronym: ").append(toIndentedString(acronym)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    domainId: ").append(toIndentedString(domainId)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
    sb.append("    ownerUserId: ").append(toIndentedString(ownerUserId)).append("\n");
    sb.append("    devTeamId: ").append(toIndentedString(devTeamId)).append("\n");
    sb.append("    bizTeamId: ").append(toIndentedString(bizTeamId)).append("\n");
    sb.append("    productOwnerName: ").append(toIndentedString(productOwnerName)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    criticalForOperation: ").append(toIndentedString(criticalForOperation)).append("\n");
    sb.append("    hasPersonalData: ").append(toIndentedString(hasPersonalData)).append("\n");
    sb.append("    securityLevel: ").append(toIndentedString(securityLevel)).append("\n");
    sb.append("    complianceRequirements: ").append(toIndentedString(complianceRequirements)).append("\n");
    sb.append("    documentationUrl: ").append(toIndentedString(documentationUrl)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    goLiveDate: ").append(toIndentedString(goLiveDate)).append("\n");
    sb.append("    sunsetDate: ").append(toIndentedString(sunsetDate)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

