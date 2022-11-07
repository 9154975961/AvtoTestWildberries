package model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Product {

    @SerializedName("time1")
    @Expose
    private Integer time1;
    @SerializedName("time2")
    @Expose
    private Integer time2;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("root")
    @Expose
    private Integer root;
    @SerializedName("kindId")
    @Expose
    private Integer kindId;
    @SerializedName("subjectId")
    @Expose
    private Integer subjectId;
    @SerializedName("subjectParentId")
    @Expose
    private Integer subjectParentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("brandId")
    @Expose
    private Integer brandId;
    @SerializedName("siteBrandId")
    @Expose
    private Integer siteBrandId;
    @SerializedName("sale")
    @Expose
    private Integer sale;
    @SerializedName("priceU")
    @Expose
    private Integer priceU;
    @SerializedName("salePriceU")
    @Expose
    private Integer salePriceU;
    @SerializedName("averagePrice")
    @Expose
    private Integer averagePrice;
    @SerializedName("benefit")
    @Expose
    private Integer benefit;
    @SerializedName("pics")
    @Expose
    private Integer pics;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("feedbacks")
    @Expose
    private Integer feedbacks;
    @SerializedName("isNew")
    @Expose
    private Boolean isNew;
    @SerializedName("colors")
    @Expose
    private List<Color> colors = null;
    @SerializedName("sizes")
    @Expose
    private List<Size> sizes = null;
    @SerializedName("diffPrice")
    @Expose
    private Boolean diffPrice;

    public Integer getTime1() {
        return time1;
    }

    public void setTime1(Integer time1) {
        this.time1 = time1;
    }

    public Integer getTime2() {
        return time2;
    }

    public void setTime2(Integer time2) {
        this.time2 = time2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getSubjectParentId() {
        return subjectParentId;
    }

    public void setSubjectParentId(Integer subjectParentId) {
        this.subjectParentId = subjectParentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getSiteBrandId() {
        return siteBrandId;
    }

    public void setSiteBrandId(Integer siteBrandId) {
        this.siteBrandId = siteBrandId;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getPriceU() {
        return priceU;
    }

    public void setPriceU(Integer priceU) {
        this.priceU = priceU;
    }

    public Integer getSalePriceU() {
        return salePriceU;
    }

    public void setSalePriceU(Integer salePriceU) {
        this.salePriceU = salePriceU;
    }

    public Integer getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Integer averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Integer getBenefit() {
        return benefit;
    }

    public void setBenefit(Integer benefit) {
        this.benefit = benefit;
    }

    public Integer getPics() {
        return pics;
    }

    public void setPics(Integer pics) {
        this.pics = pics;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Integer feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public Boolean getDiffPrice() {
        return diffPrice;
    }

    public void setDiffPrice(Boolean diffPrice) {
        this.diffPrice = diffPrice;
    }
}