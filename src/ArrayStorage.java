import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int count_resume = 0;

    void clear() {
        count_resume = 0;
    }

    void save(Resume r) {
        boolean flag = false;
        for (int i = 0; i < count_resume; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Такое резюме уже есть!");
        } else {
            storage[count_resume] = r;
            count_resume++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < count_resume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < count_resume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < count_resume; j++) {
                    storage[j] = storage[j + 1];
                }
                break;
            }
        }
        count_resume--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
 /*       Resume[] resume = new Resume[count_resume];
        for (int i = 0; i < resume.length ; i++) {
            resume[i]=storage[i];
        }
        return resume;*/
        return Arrays.copyOfRange(storage, 0, count_resume);
    }

    int size() {
        return count_resume;
    }
}
