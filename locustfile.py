from locust import HttpUser, task

class TestLab1Locust(HttpUser):

    @task
    def post_manual_event_booking(self):
        with self.client.post("http://lab1:8080/api/", json = {"eventId": 1}, catch_response=True) as response:
            if response.status_code == 201:
                response.success()  # Compra exitosa (los primeros 50)
            elif response.status_code == 400:
                response.success()  # Agotado (los siguientes 450+ peticiones)
            else:
                response.failure(f"Error inesperado: {response.status_code}")