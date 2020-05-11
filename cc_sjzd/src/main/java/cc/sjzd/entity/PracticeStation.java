package cc.sjzd.entity;

import java.util.Date;

public class PracticeStation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.center_name
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private String stationName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.create_time
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.address
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.manager
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private String manager;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.phone
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.intro
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private String intro;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.type_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private Integer typeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.center_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private Integer centerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.institute_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private Integer instituteId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column practice_station.imgs
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    private String imgs;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.id
     *
     * @return the value of practice_station.id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.id
     *
     * @param id the value for practice_station.id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.center_name
     *
     * @return the value of practice_station.center_name
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.center_name
     *
     * @param stationName the value for practice_station.center_name
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.create_time
     *
     * @return the value of practice_station.create_time
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.create_time
     *
     * @param createTime the value for practice_station.create_time
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.address
     *
     * @return the value of practice_station.address
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.address
     *
     * @param address the value for practice_station.address
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.manager
     *
     * @return the value of practice_station.manager
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public String getManager() {
        return manager;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.manager
     *
     * @param manager the value for practice_station.manager
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.phone
     *
     * @return the value of practice_station.phone
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.phone
     *
     * @param phone the value for practice_station.phone
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.intro
     *
     * @return the value of practice_station.intro
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public String getIntro() {
        return intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.intro
     *
     * @param intro the value for practice_station.intro
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.type_id
     *
     * @return the value of practice_station.type_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.type_id
     *
     * @param typeId the value for practice_station.type_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.center_id
     *
     * @return the value of practice_station.center_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public Integer getCenterId() {
        return centerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.center_id
     *
     * @param centerId the value for practice_station.center_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.institute_id
     *
     * @return the value of practice_station.institute_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public Integer getInstituteId() {
        return instituteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.institute_id
     *
     * @param instituteId the value for practice_station.institute_id
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setInstituteId(Integer instituteId) {
        this.instituteId = instituteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column practice_station.imgs
     *
     * @return the value of practice_station.imgs
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public String getImgs() {
        return imgs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column practice_station.imgs
     *
     * @param imgs the value for practice_station.imgs
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    public void setImgs(String imgs) {
        this.imgs = imgs == null ? null : imgs.trim();
    }

	public PracticeStation() {
		super();
	}

	public PracticeStation(String stationName, Date createTime, String address, String manager, String phone,
			String intro, Integer typeId, Integer centerId, Integer instituteId, String imgs) {
		super();
		this.stationName = stationName;
		this.createTime = createTime;
		this.address = address;
		this.manager = manager;
		this.phone = phone;
		this.intro = intro;
		this.typeId = typeId;
		this.centerId = centerId;
		this.instituteId = instituteId;
		this.imgs = imgs;
	}
	
}