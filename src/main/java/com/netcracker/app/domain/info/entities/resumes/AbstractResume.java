package com.netcracker.app.domain.info.entities.resumes;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@MappedSuperclass
public abstract class AbstractResume implements Resume {
    public Integer getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String phone;
    private String email;
    private String text;

    public String getAccepted() {
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    private String accepted;

    public AbstractResume() {}

    public AbstractResume(String firstName, String lastName, String birthday,
                          String phone, String email, String text) throws Exception {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        setPhone(phone);
        setEmail(email);
        setText(text);
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) throws Exception {
        Pattern pattern = Pattern.compile("[A-ZА-ЯЁ][a-zа-яё]{1,20}");
        Matcher matcher = pattern.matcher(firstName);
        if (matcher.matches()) {
            this.firstName = firstName;
        } else {
            throw new Exception("Incorrect firstName");
        }
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) throws Exception {
        Pattern pattern = Pattern.compile("[A-ZА-ЯЁ][a-zа-яё]{1,10}[-]?[a-zа-яё]{1,10}");
        Matcher matcher = pattern.matcher(lastName);
        if (matcher.matches()) {
            this.lastName = lastName;
        } else {
            throw new Exception("Incorrect lastName");
        }
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) throws Exception {
        Pattern pattern = Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*$");
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) {
            this.phone = phone;
        } else {
            throw new Exception("Incorrect phone number");
        }
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) throws Exception {
        Pattern pattern = Pattern.compile("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            this.email = email;
        } else {
            throw new Exception("Incorrect email");
        }
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) throws Exception {
        if (text != null) {
            this.text = text;
        } else {
            throw new Exception("Incorrect text about yourself");
        }
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthDate) throws Exception {
        Pattern pattern = Pattern.compile("(([0][1-9])|([12][0-9])|([3][01]))([.// -]*)(([0][1-9])|([1][0-2]))([.// -]*)(([1][9][4-9][0-9])|([2][0][0][0-5]))");
        birthDate = birthDate.trim();
        Matcher matcher = pattern.matcher(birthDate);
        if (matcher.matches()) {
            int day = 0;
            int month = 0;
            int year = 0;
            String[] digits = birthDate.split("[.|,|/|-| ]");
            if (digits[0].charAt(0) == '0') {
                day = Integer.parseInt(digits[0].substring(1));
            } else {
                day = Integer.parseInt(digits[0]);
            }
            if (digits[1].charAt(0) == '0') {
                month = Integer.parseInt(digits[1].substring(1));
            } else {
                month = Integer.parseInt(digits[1]);
            }
            year = Integer.parseInt(digits[2]);

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month - 1, day);
            if (calendar.isLenient()) {
                LocalDate date = LocalDate.of(year, month,day);
                this.birthday = date;
            } else {
                throw new Exception("Incorrect birthday");
            }
        } else {
            throw new Exception("Incorrect birthday");
        }
    }
}
